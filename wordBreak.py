class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        hs = set(wordDict)
        
        dp = [False for i in range(len(s)+1)]
        dp[0] = True
        for i in range(1, len(dp)):
            for j in range(0, i):
                if dp[j] == True and s[j:i] in hs:
                    dp[i] = True
        
        return dp[-1]
        

