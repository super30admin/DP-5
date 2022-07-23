#recursive solution and gives time exceeded error.
#TC: O(n^n)

# class Solution(object):
#     def wordBreak(self, s, wordDict):
#         """
#         :type s: str
#         :type wordDict: List[str]
#         :rtype: bool
#         """
#         def helper(s):
#             #base:
#             if len(s)==0: return True
#             #logic
#             for i in range(len(s)):
#                 str=s[:i+1]
#                 if str in wordDict and helper(s[i+1:]):
#                     return True
#             return False
        
#         return helper(s)



#DP solution
#TC: O(n^3)

class Solution(object):
    def wordBreak(self, s, wordDict):
        """
        :type s: str
        :type wordDict: List[str]
        :rtype: bool
        """
        dp=[False for _ in range(len(s)+1)]
        dp[0]=True
        for i in range(1,len(s)+1):                     #O(n)
            for j in range(i):                          #O(n)
                if dp[j] and s[j:i] in wordDict:        #O(n)
                    dp[i]=True
                    break
        return dp[-1]


#TC: O(n^3) for worst case.
#instead of traversing the dp array we store only the true index's in the array and traverse over it.
# class Solution(object):
#     def wordBreak(self, s, wordDict):
#         """
#         :type s: str
#         :type wordDict: List[str]
#         :rtype: bool
#         """
#         jIndex=[]
#         #dp=[False for _ in range(len(s)+1)]
#         #dp[0]=True
#         jIndex.append(0)
#         for i in range(1,len(s)+1):
#             for k in jIndex:
#                 if s[k:i] in wordDict:
#                     jIndex.append(i)
#                     break
#         if jIndex[-1]==len(s):
#             return True
#         else:
#             return False