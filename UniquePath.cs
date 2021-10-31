using System;
using System.Collections.Generic;
using System.Text;

namespace DP
{
    class UniquePathsLC
    {
        //TC: O(2^(m * n))
        //SC: O(m*n)
        public int UniquePaths(int m, int n)
        {
            if (m == 0 || n == 0)
            {
                return 0;
            }
            return helper(0, 0, m, n);
        }
        private int helper(int row, int col, int m, int n)
        {
            //base
            if (row == m || col == n) return 0;
            if (row == m - 1 && col == n - 1) return 1;
            //logic
            return helper(row, col + 1, m, n) + helper(row + 1, col, m, n);
        }

        //TC: O(m*n)
        //SC: O(m*n)
        public int UniquePathsDP(int m, int n)
        {
            if (m == 0 || n == 0)
            {
                return 0;
            }
            int[][] dp = new int[m][];
            for (int i = m - 1; i >= 0; i--)
            {
                for (int j = n - 1; j >= 0; j--)
                {
                    if (i == m - 1 || j == n - 1)
                    {
                        dp[i][j] = 1;
                        continue;
                    }
                    dp[i][j] = dp[i + 1][j] + dp[i][j + 1];
                }
            }
            return dp[0][0];
        }

        //TC: O(m*n)
        //SC: O(n)
        public int UniquePathsOptimized(int m, int n)
        {
            if (m == 0 || n == 0)
            {
                return 0;
            }
            if (n > m) return UniquePathsOptimized(n, m);
            int[] dp = new int[n];
            Array.Fill(dp, 1);
            for (int i = m - 2; i >= 0; i--)
            {
                int right = 0;
                for (int j = n - 1; j >= 0; j--)
                {
                    dp[j] = dp[j] + right;
                    right = dp[j];
                }
            }
            return dp[0];
        }
    }
}
