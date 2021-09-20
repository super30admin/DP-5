"""
#Dp Approach
        #T.C = O(n^4) 2loops + substing + computing hash
        #S.C = O(L)
// Did this code successfully run on Leetcode :YES
// Any problem you faced while coding this : NO
"""
class Solution(object):
    def wordBreak(self, s, wordDict):
        """
        :type s: str
        :type wordDict: List[str]
        :rtype: bool
        """
        #Dp Approach
        #T.C = O(n^4) 2loops + substing + computing hash
        #S.C = O(L)
        word_set = set(wordDict)
        dp = [False] * (len(s)+1)
        dp[0] = True
        
        for i in range(1,len(s)+1):
            for j in range(0,i):
                if(dp[j]==True):
                    if(s[j:i] in word_set):
                        dp[i] = True
                        break
        return dp[-1]
                        
        
#         #T.C = exponential
        
#         if(len(wordDict)==0 and len(s) == 0):
#             return False
#         set1 = set(wordDict)
#         return self.helper(s,set1)
#     def helper(self,s,set1):
#         if len(s) == 0:
#             return True
#         for i in range(1,len(s)+1):
#             if((s[0:i] in set1) and self.helper(s[i:],set1) ):
#                 return True
#         return False

        
         
        