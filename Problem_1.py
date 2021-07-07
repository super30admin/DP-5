# Runs on Leetcode
    # Runtime - O(n^2)
    # Space - O(n) where n is length of string
    
    
class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        if not s:
            return True
        
        wordDict = set(wordDict)
        dp = [False for i in range(len(s)+1)]
        dp[0] = True
        
        for i in range(1,len(dp)):
            for j in range(0, i):
                if dp[j] and (s[j:i] in wordDict):
                    dp[i] = True
                    
        return dp[-1]
