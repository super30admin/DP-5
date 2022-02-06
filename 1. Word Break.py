class Solution:
    # Time Complexity - O(m*n^2) - where m is the number of words in the dictionary and n is the length of the input string
    # Space Complexity - O(n) for the dp array
    def wordBreak(self, s: str, wordDict) -> bool:
        dp = [False] * (len(s) + 1)
        dp[len(s)] = True

        for i in range(len(s) - 1, -1, -1):
            for w in wordDict:
                if (i + len(w)) <= len(s) and s[i:i + len(w)] == w:
                    dp[i] = dp[i + len(w)]
                if dp[i]:
                    break

        return dp[0]