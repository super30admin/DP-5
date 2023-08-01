# Time Complexity : O(m*n)
# Space Complexity : O(m*n) to maintain the dp matrix

# The code ran on Leetcode

# The number of ways to reach a position (i, j) is number of ways it can reach (i-1, j) + number of wayd it can reach (i, j-1)

class Solution:
    def uniquePaths(self, m: int, n: int) -> int:      
        arr = [[0] * (n+1) for _ in range(m+1)]
        for i in range(1, m+1):
            for j in range(1, n+1):
                if i == 1 and j == 1:
                    arr[i][j] = 1
                else:
                    arr[i][j] = arr[i-1][j] + arr[i][j-1]
        return arr[-1][-1]