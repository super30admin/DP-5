# Time Complexity: O(nm)
# Space Complexity: O(nm)

class Solution:
    def uniquePaths(self, m, n) :
        #         Defining the dp array of length n*m
        dp = [[1 for i in range(n)] for j in range(m)]

        # We will iterate over the matrix m*n and we will add current location
        # value as upper row and same row previous column and so on and will return
        # the last element of array dp in the end
        for i in range(1, m):
            for j in range(1, n):
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1]

        return dp[m - 1][n - 1]




