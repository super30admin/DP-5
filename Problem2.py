# Problem 2 : Unique Paths
# Time Complexity : 
''''
Bottom-up: O(m*n) where m is the number of rows and n is the number of columns
Memoization: O(m*n) where m is the number of rows and n is the number of columns
'''
# Space Complexity : 
''''
Bottom-up: O(m*n) where m is the number of rows and n is the number of columns
Memoization: O(m*n) where m is the number of rows and n is the number of columns
'''
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this :
'''
None
'''

# Your code here along with comments explaining your approach
# bottom-up approach
class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        # initialize the dp matrix for length m*n and fill with 0
        dpMatrix = [[0] * (n) for _ in range(m)]
        # through the matrix
        for i in range(m):
            for j in range(n):
                # check the edge case ie if i and j are greater than 0
                if i > 0 and j > 0:
                    # if it is then calculate the value for dp[i][j] as sum of dp[i-1][j] and dp[i][j-1]
                    dpMatrix[i][j] = dpMatrix[i-1][j] + dpMatrix[i][j-1]
                else:
                    # if the i and j are less than 0 then set the dp[i][j] as 1
                    dpMatrix[i][j] = 1
        # return the value at (m-1)(n-1) position in dp matrix
        return dpMatrix[m-1][n-1]
    

# Memoization
from typing import List
class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        # initialize the memo matrix for length m*n and fill with 0
        memo =[[0]*n for _ in range(m)]
        
        # helper function to calculate the value for postion at i and j location
        def helper(m: int, n: int, i: int, j: int, memo: List[List[int]]) -> int:
            # edge case if i or j are equal to m and n then return 0
            if i == m or j == n: return 0
            # if the value of i and j are m-1 and n-1 then return 1
            if i == m-1 and j == n-1: return 1
            # check if the memo array has value for i, j position and if it is then return that value
            if memo[i][j] != 0: return memo[i][j]

            # calculate the value for bottom path
            bottom = helper(m, n, i+1, j, memo)
            # calculate the value for right path
            right = helper(m, n, i, j+1, memo)
            # calculate the result by adding the bottom and right
            result = bottom + right
            # save the value of result in the memo array
            memo[i][j] = result
            # return result
            return result
        # call helper function for 0, 0 position
        return helper(m, n, 0, 0, memo)