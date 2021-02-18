Time Complexity : O(n^3)- n^2 for the 2 for loops and another n for making substring inside each
Space Complexity : O(n)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

"""
The basic idea is, we need to explore all the possibilities, at every point we find if that substring is there inside the 
set or not. To optimise it, if it is not present inside set, we donot break it further and move forward.
We apply the same technique to DP.
"""

class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        if not s or not wordDict:
            return False
        self.words = set(wordDict)
        l = len(s)
        dp = [False for i in range(l+1)]
        dp[0] = True
        for i in range(1, l+1):
            for j in range(0, i):
                if dp[j] and s[j:i] in self.words:
                    dp[i] = True
                    break
        return dp[-1]
