#Time Complexity :O(N*M)  where N is number of elements and M is number of elemts 
#Space Complexity: O(N)  where N is number of elemets
class Solution(object):
    def wordBreak(self, s, wordDict):
        """
        :type s: str
        :type wordDict: List[str]
        :rtype: bool
        """
        wordSet = set()
        for i in wordDict:
            wordSet.add(i)
            
        dp = [False for x in range(len(s)+1)]
        dp[0] = True
        for i in range(len(dp)):
            for j in range(0,i):
                if dp[j] and s[j:i] in wordSet:
                    dp[i]=True
                    break
        return dp[len(dp)-1]

