#139. Word Break
"""
Time Complexity: O(n^2*n) = O(n^3) | O(l^4) is the actual TC where l is the length of str and we don't ignore the substr length
Space Complexity: O(h)
"""

class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        h = set(wordDict)
        dp = [False for i in range(len(s)+1)]
        dp[0] = True

        for i in range(len(s)+1): # n time
            for j in range(i): # n time
                if dp[j] and s[j:i] in h:
                    dp[i] = True
                    break

        return dp[len(s)]
