# Time Complexity : O(n^2)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Approach : We use a boolean array dp to track whether each prefix of the string can be partitioned.
# For each position in the string, we check earlier positions to see if the word between them is in the dictionary and the earlier position is reachable.
# If both conditions are true, we mark the current position as reachable and continue.

class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        set_ = set(wordDict)
        n = len(s)

        dp = [False] * (n + 1)
        dp[0] = True

        for i in range(1, n + 1):
            for j in range(i):
                if dp[j] and s[j:i] in set_:
                    dp[i] = True
                    break

        return dp[n]
        