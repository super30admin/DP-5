"""
Leetcode: https://leetcode.com/problems/word-break/

Approach: Dynamic Programming
    #(1) dp[i] = s[0:i] is breakable
    #(2) Considering all possible substrings of s.
    #(3) If s[0:j] is breakable and s[j:i] is breakable, then s[0:i] is breakable. Equivalently, if dp[j] is True
        and s[j:i] is in the wordDict, then dp[i] is True.
    #(4) Our goal is to determine if dp[i] is breakable, and once we do, we don't need to consider anything else.
        This is because we want to construct dp.
    #(5) dp[len(s)] tells us if s[0:len(s)] (or equivalently, s) is breakable.

Time complexity : O(n^3). There are two nested loops, and substring computation at each iteration. Overall that results in O(n^3) time complexity.
Space complexity : O(n). Length of p array is n+1.
"""


class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        dp = [False for i in range(len(s) + 1)]  # (1)
        dp[0] = True

        for i in range(len(s) + 1):  # (2)
            for j in range(i):
                if dp[j] and s[j:i] in wordDict:  # (3)
                    dp[i] = True
                    break  # (4)

        return dp[len(s)]  # (5)