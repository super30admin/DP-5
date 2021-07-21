'''
====== Submission Details =======
Student Name: Pavan Kumar K. N.
S30 SlackID : RN32MAY2021
=================================
'''

# 139. Word Break

# https://leetcode.com/problems/word-break/
#-----------------
# Time Complexity: 
#-----------------
# O(N^3) - where N is the number of chars in input word

#------------------
# Space Complexity: 
#------------------
# O(N): DP array of size N+1

#-----------------------
# Leet Code Performance: 
#-----------------------
# Ran Successfully?: Yes


class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        if len(s) == 0:
            return False
        hashset = set(wordDict)
        n = len(s)
        dp = [False for i in range(n + 1)]
        
        dp[0] = True
        
        for i in range(1, len(dp)):
            for j in range(i):
                if dp[j] and s[j:i] in hashset:
                    dp[i] = True
                    break
        return dp[-1]
                        
                    
                        
                    