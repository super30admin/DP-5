# Time Complexity: O(mn), where m - rows and n - cols
# Space Complexity: O(n)

class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        if m == 0:
            return 0

        # Initialize dp array of size n with 1 since there is only one way to reach the last row and col
        dp = [1 for x in range(n)]

        # Update the num of paths for the other cells by adding the paths from right and down direction
        for i in range(m - 2, -1, -1):
            for j in range(n - 2, -1, -1):
                dp[j] = dp[j] + dp[j + 1]

        # First cell gives the total no of unique paths to reach the last cell
        return dp[0]
