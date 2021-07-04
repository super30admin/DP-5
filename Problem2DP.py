# Time Complexity : O(M*N) 
# Space Complexity : O(M*N) 
# Did this code successfully run on Leetcode : Yes
# Three line explanation of solution in plain english:
# - This can be solved using dynamic programming. If we start from [0][0] cell to reach anywhere in first row and first column there is only one way because we can move only in right or down direction. 
# - For all other cells to reach there we can use all paths coming to it's left cell and it's top cell.
# - So we combine both left cell's path and top cell's path to get total path to reach current cell.

class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
#       COver corner cases
        if not m or not n:
            return 0
#       Initialize dp matrix with 1 so we don't have to make first row and column 1 afterward.
        dp = [[1 for _ in range(n)] for _ in range(m)]
#       Iterate through all cell except first row and first column.
        for i in range(1, m):
            for j in range(1, n):
#               Update current cell's value as sum of left cell's value and right cell's value.
                dp[i][j] = dp[i-1][j] + dp[i][j-1]
                
#       Return last row and last column cell's value that has total path reaching there.
        return dp[-1][-1]
