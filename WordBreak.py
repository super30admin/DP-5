#All TC passed on leetcode


class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:

        #Here for every char position of s we check if its possible to split and create the string. If yes then it is stored as True in dp array.
         #Time complexity - O(n^3) - where n is length of s. n^2 for i and j iteration i.e. for every i we traverse j from 0 to i. Another O(n) is required for creating substrings in every iteration.
        #Space complexity - O(n)
        wordSet = set()
        for w in wordDict:
            wordSet.add(w)
        
        dp = [False]*(len(s)+1)
        dp[0] = True

        for i in range(len(s)+1):
            for j in range(i):
                if dp[j] and s[j:i] in wordSet:
                    dp[i] = True
                    break
        return dp[-1]


        

#----------------------------------------OR-----------------------------------------------
        #Time complexity - O(n^n) here for every letter we check if remanining letters are present one by one i.e for word=leetcode we check if 'l' is there then we check if 'e'->'ee'->'eet'->'eetc'->'eetco'->'eetcode' is present
        #Space complexity O(1)
        wordSet = set()
        for w in wordDict:
            wordSet.add(w)
        
        def helper(word, wordSet):
            if len(word)==0:
                return True
            
            for i in range(len(word)):
                sub = word[0:i+1]
                if sub in wordSet and helper(word[i+1:], wordSet):
                    return True
            return False

        return helper(s, wordSet)

        