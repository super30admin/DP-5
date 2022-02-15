class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        if s is None or len(s) == 0:
            return True

        _set = set()
        _set.update(wordDict)
        print(_set)

        dp = [False] * (len(s) + 1)

        dp[0] = True

        for i in range(1, len(s) + 1):
            for j in range(0, i):
                if dp[j] == True and s[j:i] in _set:
                    dp[i] = True

        return dp[-1]

