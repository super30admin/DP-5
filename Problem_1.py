# Time Complexity: O(n^3)
# Space Complexity: O(n^2 + summation(wordDict[i]))
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this: No

class Solution(object):
    def wordBreak(self, s, wordDict):
        """
        :type s: str
        :type wordDict: List[str]
        :rtype: bool
        """
        n = len(s)
        dp = [True]
        for i in range(1, n + 1):
            dp.append(any(dp[j] and s[j:i] in wordDict for j in range(i)))
        return dp[-1]