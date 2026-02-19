// 62. Unique Paths

/**
Memoization Intuition:
From each cell, the number of unique paths equals the sum of paths from the cell to the right and the cell below.
If we go out of bounds, there are 0 paths, and if we reach the bottom-right cell, there is exactly 1 path.
We use memoization to cache results for each `(row-col)` so we don’t recompute overlapping subproblems.
T.C: O(m*n)
S.C: O(m*n)
 */
var uniquePaths = function (m, n) {
    let result = 0;
    let memo = {};
    const helper = (row, col) => {
        // base
        if (row === m || col === n) return 0;

        //action
        if (row === m - 1 && col === n - 1) return 1;

        const key = `${row}-${col}`;

        if (key in memo) {
            return memo[key];
        }

        // recursion
        const total = helper(row, col + 1) + helper(row + 1, col);
        memo[key] = total;
        return total;
    }
    return helper(0, 0);
};

/**
Tabulation Intuition:
Each cell’s paths equal the sum of paths from the cell above and the cell to the left.
The first row and first column are initialized to 1 because there is only one way to reach those cells.
We build the table bottom-up and return the value at the bottom-right cell.
T.C: O(m*n), S.C: O(m*n)
 */
var uniquePaths = function (m, n) {
    let dp = Array.from({ length: m }, () => new Array(n).fill(0));
    // fill first row and first col
    for (let i = 0; i < m; i++) {
        dp[i][0] = 1;
    }
    for (let i = 0; i < n; i++) {
        dp[0][i] = 1;
    }
    for (let i = 1; i < m; i++) {
        for (let j = 1; j < n; j++) {
            dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
        }
    }
    return dp[m - 1][n - 1];
};