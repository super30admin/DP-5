// Time Complexity : O(M*N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : DP IS HARD

/**
 * @param {number} m
 * @param {number} n
 * @return {number}
 */

var uniquePaths = function(m, n) {
    if (!m || !n) return 0;
    let dp = new Array(n).fill(1);
    for (let i = 1; i < m; i++) {
        for (let j = 1; j < n; j++) dp[j] += dp[j - 1];
    }
    return dp[n - 1];
};
