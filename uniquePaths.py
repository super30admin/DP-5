
def uniquePaths(m, n):
    # Create a 2D dp array initialized with 1s
    dp = [[1] * n for _ in range(m)]
    print(dp)
    
    # Fill the dp table
    for i in range(1, m):
        for j in range(1, n):
            dp[i][j] = dp[i-1][j] + dp[i][j-1]
    print(dp)
    
    # The answer is in the bottom-right corner of the grid
    return dp[m-1][n-1]

# Example usage:

m = 3
n = 3
print(uniquePaths(m, n))  # Output: 6

# Time Complexity: O(m×n)
# Space Complexity: O(m×n)


