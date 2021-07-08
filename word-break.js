// Time Complexity : O(N^2)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : DP IS HARD

/**
 * @param {string} s
 * @param {string[]} wordDict
 * @return {boolean}
 */
var wordBreak = function(s, wordDict) {
    if (!s || !s.length) return false;
    if (!wordDict || !wordDict.length) return false;
    if (s.length == 1 && s.length == wordDict.length && s == wordDict[0]) return true;

    const wordSet = new Set(wordDict);
    const isValid = new Array(s.length).fill(false);
    
    if (wordSet.has(s)) return true;
    
    for (let i = 0; i < s.length; i++) {
        let k = i;
        while (k >= 0) {
            let sub = s.substring(k, i + 1);
            if (wordSet.has(sub) && (k == 0 || isValid[k - 1])) {
                isValid[i] = true;
                break;
            }
            k--;
        }
    }

    return isValid[s.length - 1];
};
