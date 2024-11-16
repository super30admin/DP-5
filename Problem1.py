# 139. Word Break
class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        dp = [False for _ in range(len(s) + 1)]
        dp[0] = True
        for i in range(1,len(s)+1):
            for j in range(0,i):
                subs = s[j:i]
                if subs in wordDict and dp[j]:
                    dp[i] = True
                    break

        return dp[len(s)]

        