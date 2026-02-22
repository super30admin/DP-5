// Solution 1: DP with 1D array
// TC - O(m*n) - iterate over matrix once.
// SC - O(n) - DP array space.
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        if (set.contains(s))
            return true;
        int l = s.length();
        boolean[] dp = new boolean[l + 1];
        dp[0] = true;

        for (int i = 1; i <= l; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j]) {
                    if (set.contains(s.substring(j, i))) {
                        dp[i] = true;
                        break;
                    }
                }
            }
        }
        return dp[l];
    }
}

// Solution 2: Recursion with memoization
// TC - O(n^2) - iterate over string and for each character iterate over
// remaining string.
// SC - O(n) - recursion stack space and memoization space.
// class Solution {
// HashSet<String> memo;
// public boolean wordBreak(String s, List<String> wordDict) {
// this.memo = new HashSet<>();
// HashSet<String> set = new HashSet<>();

// return helper(s, wordDict, 0);
// }

// private boolean helper(String s, List<String> wordDict, int idx) {

// // Base
// if(idx == s.length()) return true;

// // Memoize
// String subStr = s.substring(idx, s.length());
// if(memo.contains(subStr)) return false;

// // Logic
// for(int i=idx; i<= s.length(); i++) {

// if(wordDict.contains(s.substring(idx, i))) {
// if(helper(s, wordDict, i)) {
// return true;
// }
// }
// }
// memo.add(subStr);
// return false;

// }
// }