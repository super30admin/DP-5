class Solution(object):
    def wordBreak(self, s, wordDict):
        """
        :type s: str
        :type wordDict: List[str]
        :rtype: bool
        """
        # We parse the substring from start and check if it exists in the dictionary; if it does, we recursively check the remaining string, and if a correct split is found, we return True. 
        # If the first split doesn’t work, we continue increasing the substring to find other splits that may return True. 
        # If we reach the end without finding a valid split, we return False. In the recursive approach, for catsanddog and wordDict = [cat, cats, sand, and, dog],
        # breaking to "sand" or "and" leads to overlapping substring computations. This can be costly, but using memoization to store the result for that start index avoids recomputation and reduces time complexity.
        # tc  : O(n2) worst case checks up to all the substrs possible which is n2, 
        # sc : O(n) savign all the index , + O(n) recrussive stack - > O(n)

        # given worddict is unique but searvhing in a list takes O(n) but searvching in set takes O(1) so will be using a set fo wordDict
        self.memo = {}
        return self.helper(s,0,set(wordDict))

    def helper(self,s,start,wordDict):
        if start == len(s):
            return True

        if start in self.memo: # tc : O(1)
            return self.memo[start]

        for j in range(start,len(s)): # tc : O(n)
            word = s[start:j+1] 
            if word in wordDict: # tc : O(1)
                if self.helper(s,j+1,wordDict):
                    self.memo[start] = True
                    return True

        self.memo[start] = False
        return False
        
