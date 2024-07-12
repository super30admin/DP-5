# Time Complexity : O(n^2)
# Space Complexity : O(n)
from typing import List
class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        sets = set(wordDict)
        dp = [False]*(len(s)+1)
        dp[0] = True

        for i in range(1, len(dp)):
            for j in range(0, i):
                if dp[j] and s[j:i] in sets:
                    dp[i] = True
                    break
        return dp[len(s)]