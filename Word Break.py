#// Time Complexity : O(n ^ 2) 
# // Space Complexity : O(n + m) 
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : No.

class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        wordDict = set(wordDict)
        n = len(s)
        dp = [False] * (n + 1)  # dp[i] represents whether the substring s[0:i] can be segmented into words in the dictionary
        dp[0] = True  # Base case: empty string 
                    #Initialize dp[0] to True because an empty string (substring of length 0) can always be segmented.

        for i in range(1, n + 1):
            for j in range(i):
                # print(dp[j],s[j:i])
                if dp[j] and s[j:i] in wordDict:
                    dp[i] = True
                    break
        
        return dp[n]

# DP approach bottom up.

# DP approach memoization T:O(n⋅m⋅k) S: O(n)
#         dp=[-1]*(len(s)+1)
#         wordDict=set(wordDict)
#         def recurr(idx):
#             if idx==len(s): # We found the words
#                 return True
#             if dp[idx]!=-1:
#                 return dp[idx]

#             if s[idx:] in wordDict:  # we check if remaining string is there in word Dict or not

#                 return True
#             for l in range(1,len(s)):
#                 temp=s[idx:idx+l] 
#                 if temp in wordDict and recurr(idx+l):
#                     dp[idx]=True
#                     return dp[idx]
#             dp[idx]=False
#             return dp[idx]
#         return recurr(0)

# Approach:
# 1.  We use a dynamic programming (DP) approach to solve this problem. We create a
# dp array of size n+1, where dp[i] represents whether the substring s[0]
# 2.  We initialize dp[0] to True because an empty string can always be segmented.
# 3.  We iterate over the string s from left to right. For each position i, we
# check all substrings s[j:i] where j is a position less than i. If the substring
# s[j:i] is in the word dictionary and dp[j] is True, it means that s[0:j] can be segmented into words in the dictionary, and s[j:i]
# can also be segmented into words in the dictionary. Therefore, we set dp[i] to True
# 4.  Finally, we return dp[n], which represents whether the entire string s can be segmented into words in the dictionary.
