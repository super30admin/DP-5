// ## Problem2: (https://leetcode.com/problems/unique-paths/)

// 1d DP
// Time Complexity : O(mn)
// Space Complexity : O(n)

// 2d DP
// Time Complexity : O(mn)
// Space Complexity : O(mn)

// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

/**
 * @param {number} m
 * @param {number} n
 * @return {number}
 */
var uniquePaths = function (m, n) {
    if (m === 0 && n === 0)
        return 0;

    // 1D array solution
    let dp = new Array(n);
    dp.fill(0);
    dp[n - 1] = 1;
    for (let i = m - 1; i >= 0; i--) {
        // For each row, go through each column
        for (let j = n - 2; j >= 0; j--) {
            // Add right and bottom. Bottom value is the value itself
            dp[j] = dp[j] + dp[j + 1];
        }
    }
    return dp[0]

    // Create a 2d DP array of length m+1, n+1
    // The last row and colum = 0
    // dp[m-1][n-1] = 1 as this indicates if only 1 cell was present, number of ways to reach it would be 1
    // For each other celss, update value to value from right+value from bottom
    // let dp = new Array(m+1);
    // for(let i=0; i<dp.length; i++){
    //     dp[i] = new Array(n+1);
    //     dp[i].fill(0);
    // }

    // for(let i=m-1; i>=0; i--){
    //     for(let j=n-1; j>=0; j--){
    //         if(i===m-1 && j=== n-1){
    //             dp[i][j] = 1;
    //             continue;
    //         } else {
    //             dp[i][j] = dp[i+1][j]+dp[i][j+1];
    //         }
    //     }
    // }
    // return dp[0][0];
};