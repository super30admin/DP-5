class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        wordDict = set(wordDict)
        n = len(s)
        dp = [False for i in range(n + 1)]
        dp[n] = True
        
        for start in range(n - 1, -1, -1):
            dp[start] = False
            for i in range(start, n):
                if s[start: i + 1] in wordDict and dp[i + 1]:
                    dp[start] = True
                    break
            
        return dp[0]