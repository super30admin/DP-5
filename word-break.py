"""
Runtime COmplexity: O(n^4) - two for loops and for checking the substring O(n), and to search in the hashset it takes another O(n).
Space Complexity: O(n) - dp array of size n.
Yes, the code worked on leetcode.
Issues while coding- No
"""

class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        hashset = set(wordDict)
        n = len(s)
        dp = [False for i in range(n+1)]
        dp[0] = True
        for i in range(1,n+1):
            for j in range(0,i):
                if dp[j]:
                    if s[j:i] in hashset:
                        dp[i] = True
                        break
        return dp[n]
        