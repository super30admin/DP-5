// 62. Unique Paths
// https://leetcode.com/problems/unique-paths/description/

// Solution 1 => Recursion

/**
 * Time Complexity: O(2 ^ m + n) since we take 2 decisions at every step and the max steps till we reach bottom-right corner is m + n
 * Space Complexity: O(m + n) which is depth of the tree
 */

class Solution {

  int result;

  public int uniquePaths(int m, int n) {
    this.result = 0;

    helper(m, n, 0, 0);

    return result;
  }

  private void helper(int m, int n, int i, int j) {
    // base
    if (i == m - 1 && j == n - 1) {
      result++;
      return;
    }

    // bound check
    if (i >= m || j >= n) {
      return;
    }

    // logic

    // right
    helper(m, n, i, j + 1);

    //bottom
    helper(m, n, i + 1, j);
  }
}

// Solution 2 => Memoization

/**
 * Time Complexity: O(m * n), since we calculate ways for each position in matrix only once
 * Space Complexity: O(m * n) + O(m + n), (m * n) for grid and (m + n) for call stack
 */

class Solution {

  int memo[][];

  public int uniquePaths(int m, int n) {
    this.memo = new int[m][n];

    for (int i = 0; i < m; i++) {
      Arrays.fill(memo[i], -1);
    }

    return helper(m, n, 0, 0);
  }

  private int helper(int m, int n, int i, int j) {
    // base
    if (i == m - 1 && j == n - 1) {
      return 1;
    }

    // bound check
    if (i >= m || j >= n) {
      return 0;
    }

    // logic

    // if no. of ways for this position is already calculated, return previous calculation
    if (memo[i][j] != -1) {
      return memo[i][j];
    }

    // right                  // bottom
    memo[i][j] = helper(m, n, i, j + 1) + helper(m, n, i + 1, j);

    return memo[i][j];
  }
}

// Solution 3 => Tabulation

/**
 * Time Complexity: O(m * n), since we calculate ways for each position in matrix only once
 * Space Complexity: O(n) since we use 1d array of size n
 */


class Solution {
    public int uniquePaths(int m, int n) {
        int dp[] = new int[n];

        Arrays.fill(dp, 1);

        for(int i = m - 2 ; i >= 0 ; i--){
            for(int j = n - 2 ; j >= 0 ; j--){
                dp[j] = dp[j + 1] + dp[j];
            }
        }

        return dp[0];
    }
}
