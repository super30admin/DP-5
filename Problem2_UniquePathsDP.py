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
# O(M x N) - where M is the number of rows and N is the number of columns

#------------------
# Space Complexity: 
#------------------
# O(N): DP array of size N+1

#-----------------------
# Leet Code Performance: 
#-----------------------
# Ran Successfully?: Yes


class Solution:
    
    def uniquePaths(self, m: int, n: int) -> int:
        if m == 0 and n==0:
            return 0
        if n>m:
            return self.uniquePaths(n, m)
        
        self.dp = [1 for j in range(n+1)]
        
        
        for i in range(m-2, -1, -1):
            right = 0
            for j in range(n-1, -1, -1):
                if i == m-1 and j == n-1:
                    continue
                    
                self.dp[j] = self.dp[j] + right
                right = self.dp[j]
                
        
        return self.dp[0]
                        
                    
                        
                    