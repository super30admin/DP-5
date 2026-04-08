# Time Complexity : O(n^2)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Approach: Use recursion + memoization.
# At each index i, try all possible substrings s[i:j].
# If a substring exists in the dictionary, recursively check the remaining string.
# Use memo to store results for index i to avoid recomputation.
# If we reach the end of the string, return True indicating valid segmentation.

class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        wordSet = set(wordDict)
        memo = {}

        def helper(i):
            if i == len(s):
                return True

            if i in memo:
                return memo[i]

            for j in range(i + 1, len(s) + 1):
                if s[i:j] in wordSet:
                    if helper(j):
                        memo[i] = True
                        return True

            memo[i] = False
            return False

        return helper(0)