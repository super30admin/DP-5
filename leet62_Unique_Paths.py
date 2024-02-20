# Solution

# // Time Complexity : Exhaustive Time Limit Exceeded approach O(2^(m+n))
#                      DP approach O(m*n)
# // Space Complexity : Exhaustive Time Limit Exceeded approach O(2^(m+n)) implicit recursions
#                       DP approach O(m*n) matrix to hold the values for each input cell
#                       Bit more optimized it will be O(n) n columns
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : None


# // Your code here along with comments explaining your approach
# Approach is for each cell we can either go down or right. Also at each cell number ways to reach the cell is either from up
# or left. So we can keep adding from up and left to get the final result

# # Best solution
def uniquePaths(m,n):
    grid = [1 for _ in range(n)]

    for j in range(1,m):
        for i in range(1,n):
            grid[i] += grid[i-1]

    return grid[n-1]

# 2D Matrix approach, DP with Exhaustive
# def helper(i,j,m,n,dp):
#     if i>m-1 or j>n-1:
#         return 0

#     if dp[i][j] != 0:
#         return dp[i][j]

#     if i == m-1 and j == n-1:
#         return 1
    
#     dp[i][j] = (helper(i+1,j,m,n,dp) + helper(i,j+1,m,n,dp))
#     return dp[i][j]

# def uniquePaths(m, n):
#     dp = [[0 for _ in range(n)] for _ in range(m)]
#     return helper(0,0,m,n,dp)

# Exhaustive Approach
# def uniquePaths(m, n):
#         return helper(0,0,m,n)

# def helper(i,j,m,n):
#     if i>m-1 or j>n-1:
#         return 0

#     if i == m-1 and j == n-1:
#         return 1
    
#     return (helper(i+1,j,m,n) + helper(i,j+1,m,n))

if __name__ == "__main__":
    m = 3
    n = 7
    print(uniquePaths(m,n))