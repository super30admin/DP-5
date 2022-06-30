#Time Complexity: O(N*N*N)
#Space Complexity: O(N)
class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        sett = set(wordDict)
        dp = [False] * (len(s) + 1)
        dp[0] = True

        for i in range(1, len(s) + 1):
            for j in range(i):
                if dp[j] and s[j:i] in sett:
                    dp[i] = True
                    break
        return dp[len(s)]