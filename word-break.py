class Solution(object):
    def wordBreak(self, s, wordDict):
        """
        :type s: str
        :type wordDict: List[str]
        :rtype: bool
        """
        #DP Optimized
        hashSet = set(wordDict)
        dp = [None for i in range(len(s)+2)]
        dp[0] = True
        for i in range(len(dp)):
            for j in range(i+1):
                if dp[j] and s[j:i] in hashSet:
                    dp[i] = True
                    break
        return dp[len(s)]
                
        
        #BruteForce
#         hashSet = set(wordDict)
#         def helper(curr):
#             #Base
#             if len(curr) == 0: return True
#             #Logic
#             for i in range(len(curr)):
#                 sub = curr[0:i+1]
#                 if sub in hashSet and helper(curr[i+1:]):
#                     return True
#             return False

#         return helper(s)