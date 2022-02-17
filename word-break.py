'''
TC: O(n^3)
SC: O(n)

Intuition: Top Down Approach
'''

class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        
        
        def rec(idx, s, wordDict, dp):
            #base
            if idx == len(s):
                return True
            
            if dp[idx] != None:
                return dp[idx]
            
            #logic
            res = False
            
            for i in range(idx, len(s)):
                if s[idx:i+1] in wordDict:
                    res = res or rec(i+1, s, wordDict, dp)
            dp[idx] = res
            
            return dp[idx]
        
        dp = [None for i in s]
        
        rec(0, s, wordDict, dp)
        return dp[0]
            