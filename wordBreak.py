class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        n = len(s)
        if s is None or len(s) == 0:
            return False
        dp = [0] * (n + 1)
        wordDict = set(wordDict)
        dp[0] = True
        for i in range(1, len(dp)):
            for j in range(i):
                x = s[j:i]
                if dp[j] and (x in wordDict):
                    dp[i] = True
                    break
        return dp[-1]
