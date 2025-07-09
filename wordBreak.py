"""
Apply Dp, dp[i] to track if s[0:i] can be broken using dictionary words
For each i, check all j < i where s[j:i] is in the dictionary and dp[j] is True
If found, make dp[i] = True
"""
"""
Time Complexity - O(n^2) — n = len(s)
Space Complexity - O(n) — for DP array and set lookup
"""

class wordBreaks:
    def wordBreak(self, s: str, wordDict: list[str]) -> bool:
        word_set = set(wordDict)
        dp = [False] * (len(s) + 1)
        dp[0] = True

        for i in range(1, len(s) + 1):
            for j in range(i):
                if dp[j] and s[j:i] in word_set:
                    dp[i] = True
                    break

        return dp[len(s)]

if __name__ == "__main__":
    obj = wordBreaks()
    s = "leetcode"
    wordDict = ["leet", "code"]
    print(obj.wordBreak(s, wordDict))
