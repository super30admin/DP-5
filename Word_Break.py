# Time Complexity : O(n^3)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
#
#
# Your code here along with comments explaining your approach
class Solution:
    def wordBreak(self, s: str, wordDict) -> bool:
        dictu = set(wordDict)
        dp = [0]
        for i in range(1, len(s)+1):
            for j in range(len(dp)):
                x = s[dp[j]:i]
                if s[dp[j]:i] in dictu:
                    dp.append(i)
                    break
        return dp[-1] == len(s)


print(Solution().wordBreak('leetcode', ['leet', 'code']))

# TC: O(n^3); SC: O(n)
# class Solution:
#     def wordBreak(self, s: str, wordDict) -> bool:
#         dictu = set(wordDict)
#         dp = [False] * (len(s) + 1)
#         dp[0] = True
#         for i in range(1, len(s) + 1):
#             for j in range(i):
#                 if dp[j] and s[j:i] in dictu:
#                     dp[i] = True
#                     break
#         return dp[-1]
#
#
# print(Solution().wordBreak('leetcode', ['leet', 'code']))


# Exhaustive
# TC: exponential.
# class Solution:
#     def helper(self, s):
#         # base
#         if len(s) == 0:
#             return True
#         # logic
#         for i in range(len(s)):
#             if s[:i+1] in self.dictu:
#                 check = self.helper(s[i+1:])
#                 if check:
#                     return True
#         return False
#
#     def wordBreak(self, s: str, wordDict) -> bool:
#         self.dictu = set(wordDict)
#         return self.helper(s)
#
#
# print(Solution().wordBreak('leetcode', ['leet', 'code']))
