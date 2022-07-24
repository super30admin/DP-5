""""// Time Complexity : O(n^3)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
"""
class Solution:
    def wordBreak(self, s: str, wordDict) -> bool:
        hashset = set(wordDict)
        dp = [0]
        for i in range(1, len(s) + 1):
            for j in range(len(dp)):
                k = dp[j]
                if s[k:i] in hashset:
                    dp.append(i)
                    break
        return dp[-1] == len(s)

""""// Time Complexity : O(n^3)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
"""
# class Solution:
#     def wordBreak(self, s: str, wordDict) -> bool:
#         hashset = set(wordDict)
#         dp = [False]*(len(s)+1)
#         dp[0] = True
#         for i in range(1, len(s)+1):
#             for j in range(i):
#                 if dp[j] and s[j:i] in hashset:
#                     dp[i] = True
#                     break
#         return dp[-1]

# Recursive
# class Solution:
#     def wordBreak(self, s: str, wordDict) -> bool:
#         self.h = set(wordDict)
#         return self.helper(s)

#     def helper(self, s):
#         # base
#         if len(s) == 0:
#             return True
#         # logic
#         for i in range(len(s)):
#             if s[:i+1] in self.h and self.helper(s[i+1:]):
#                     return True
#         return False
