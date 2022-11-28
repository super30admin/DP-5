"""
Bottom up approach
Make all the elemnts in the array as false
Then loop from last to first
Check if the length of the word is equal to the string and if the word is equal to the string --
then mark that cell as i+len(w) which we would have previously calculated
If we get true as the last i.e dp[0] then return true else false

TC : O(n^3)
SC : O(n)
"""


class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        dp = [False] * (len(s) + 1)
        dp[-1] = True

        for i in range(len(s) - 1, -1, -1):
            for w in wordDict:
                if i + len(w) <= len(s) and s[i:i + len(w)] == w:
                    dp[i] = dp[i + len(w)]

                if dp[i]:
                    break

        return dp[0]
