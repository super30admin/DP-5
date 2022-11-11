// ## Problem1: (https://leetcode.com/problems/word-break/)

// Time Complexity : O(m^3), 2 loops and substring calculation
// Space Complexity : O(m+n); m is string length, n is worddict length
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

/**
 * @param {string} s
 * @param {string[]} wordDict
 * @return {boolean}
 */
var wordBreak = function (s, wordDict) {
    if (s === null || s.length === 0 || wordDict === null || wordDict.length === 0)
        return false;

    // Add words in set for O(1) lookup
    let set = new Set();
    wordDict.forEach((word) => set.add(word));

    // Create a dp. Each dp[index] indicates if the word till that index is possible to build usinf word dict
    let dp = new Array(s.length + 1);
    dp.fill(false)
    // 1st is true as empty string is possible to build
    dp[0] = true;
    for (let i = 1; i < dp.length; i++) {
        // For each index after 0
        for (let j = 0; j < i; j++) {
            // Test all possible substrings, if any index is false i.e it was not possible to build a string previous to it with worddic, ignore and move to next
            if (dp[j] === false) {
                continue;
            }
            let str = s.slice(j, i);
            // If set has the substring, mark it at true and move to next
            if (set.has(str)) {
                dp[i] = true;
                break;
            }
        }
    }
    // Last index will have the result
    return dp[dp.length - 1];
};