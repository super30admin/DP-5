"""
Time Complexity: O(n^3)
Space Complexity: O(n)
"""
class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        if not s or not wordDict: return
        dp = [False] * (len(s) + 1)
        dp[0] = True
        hashset = set(wordDict)
        
        for i in range(1, len(dp)):
            for j in range(0, i):
                if (dp[j] == True) and (s[j : i] in hashset):
                        dp[i] = True
                        break
        
        return dp[-1]