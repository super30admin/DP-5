# class Solution:
#     def wordBreak(self, s, wordDict):
#         wordset = set(wordDict)
#         return self.helper(0, s, wordset)

#     def helper(self, index, s, wordset):
#         if index >= len(s):
#             return True
#         for i in range(index + 1, len(s) + 1):
#             currStr = s[index:i]
#             if currStr in wordset:
#                 if self.helper(i, s, wordset):
#                     return True
#         return False
    

# class Solution:
#     def wordBreak(self, s, wordDict):
#         wordset = set(wordDict)
#         return self.helper(s, wordset)

#     def helper(self, s, wordset):
#         if not len(s):
#             return True

#         for i in range(len(s)):
#             currStr = s[: i + 1]
#             if currStr in wordset:
#                 if self.helper(s[i + 1 :], wordset):
#                     return True
#         return False
    
# class Solution:
#     def wordBreak(self, s, wordDict):
#         wordset = set(wordDict)
#         memo = set()
#         return self.helper(s, wordset, memo)

#     def helper(self, s, wordset, memo):
#         if not len(s):
#             return True
#         if s in memo:
#             return False
#         for i in range(len(s)):
#             currStr = s[: i + 1]
#             if currStr in wordset:
#                 if self.helper(s[i + 1 :], wordset, memo):
#                     return True
#         memo.add(s)
#         return False

class Solution:
    def wordBreak(self, s, wordDict):
        wordSet = set(wordDict)
        memo = [False] * (len(s) + 1)
        memo[0] = True
        for i in range(1, len(s) + 1):
            for j in range(i):
                if memo[j] and s[j:i] in wordSet:
                    memo[i] = True
                    break
        return memo[len(s)]
