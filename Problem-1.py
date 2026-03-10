# Time Complexity : O(n * k), n = length of s, k = max length of words in wordDict
# Space Complexity : O(n), for the DP array
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Explanation:
# 1. Use dynamic programming where dp[i] is True if s[:i] can be segmented into words from wordDict.
# 2. For each position i, check all j < i; if dp[j] is True and s[j:i] in wordDict, set dp[i] = True.
# 3. Return dp[n], where n = len(s).

from typing import List

class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        word_set = set(wordDict)
        n = len(s)
        dp = [False] * (n + 1)
        dp[0] = True  # empty string
        
        for i in range(1, n + 1):
            for j in range(i):
                if dp[j] and s[j:i] in word_set:
                    dp[i] = True
                    break
        return dp[n]