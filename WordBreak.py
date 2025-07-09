from typing import List

# class Solution:
#     def wordBreak(self, s: str, wordDict: List[str]) -> bool:
#         hashset = set()
#         for w in wordDict: hashset.add(w)
#         def helper(s,hashset,pivot):
#             # base
#             if pivot>=len(s): return True
#             # logic
#             for i in range(pivot, len(s)):
#                 sub = s[pivot:i+1]
#                 if sub in hashset and helper(s, hashset,i+1):
#                     return True
#             return False
        
#         return helper(s, hashset,0)

# class Solution:
#     def wordBreak(self, s: str, wordDict: List[str]) -> bool:
#         hashset = set()
#         self.memo = {}
#         for w in wordDict: hashset.add(w)
#         def helper(s,hashset,pivot):
#             # base
#             if pivot>=len(s): return True
#             if pivot in self.memo: return self.memo[pivot]
#             # logic
#             for i in range(pivot, len(s)):
#                 sub = s[pivot:i+1]
#                 if sub in hashset and helper(s, hashset,i+1):
#                     self.memo[pivot] = True
#                     return True
#             self.memo[pivot] = False
#             return False
        
#         return helper(s, hashset,0)

# class Solution:
#     def wordBreak(self, s: str, wordDict: List[str]) -> bool:
#         dp = [False]* (len(s)+1)
#         wordSet = set(wordDict)
#         dp[0] = True
#         for i in range(1,len(s)+1):
#             for j in range(i):
#                 if dp[j] and s[j:i] in wordSet:
#                     dp[i] = True
#                     break
#         return dp[len(s)]
        
class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        wordSet = set(wordDict)
        n = len(s)
        dp = [False] * (n + 1)
        dp[n] = True  # base case: empty string is valid

        for i in range(n - 1, -1, -1):
            for j in range(i + 1, n + 1):
                if s[i:j] in wordSet and dp[j]:
                    dp[i] = True
                    break

        return dp[0]
        
        