# Time Complexity: O(n^2) - there are n starting indices and n possible substring lengths
# Space Complexity: O(n) recursion stack + O(n) memo
# class Solution:
#     def wordBreak(self, s: str, wordDict: List[str]) -> bool:
#         hSet = set(wordDict)
#         memo = {}
#         n = len(s)
#         return self.helper(s, hSet, 0, memo)
    
#     def helper(self, s, hSet, pivot):
#         # base
#         if pivot == len(s):
#             return True

#         if pivot in memo:
#             return memo[pivot]
#         # logic
#         for i in range(pivot,len(s)):
#             subStr = s[pivot:i+1]
#             if subStr in hSet and self.helper(s, hSet, i+1):
#                 memo[pivot] = True
#                 return True
#         memo[pivot] = False
#         return False

# Time Complexity: O(n^2) for nested loop through s
# Space Complexity: O(n) for the dp array
class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        hSet = set(wordDict)
        dp = [False] * (len(s)+1)
        dp[0] = True
        for i in range(len(s)+1):
            for j in range(i):
                if dp[j] == True and s[j:i] in hSet:
                    dp[i] = True
                    break
        return dp[len(dp)-1]