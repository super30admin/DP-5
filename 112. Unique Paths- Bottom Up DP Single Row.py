class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        if m == 0 and n == 0:
            return 0
        dp = [1] * n

        for i in range(m - 2, -1, -1):
            for j in range(n - 2, -1, -1):
                # print(m, i, n, j, dp)
                # if i == m-1 and j == n- 1:
                #     continue
                dp[j] = dp[j] + dp[j + 1]
        return dp[0]

# Bottom Up DP using single row
# Time Complexity: O(m * n)
# Space Complexity: O(n)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : No
