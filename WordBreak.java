// TC: O(n ^ 2)
// SC: O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    // TC = O(exponential), SC = O(n) - set + rec stack space
    // HashSet<String> set;
    // public boolean wordBreak(String s, List<String> wordDict) {
    //     if(s == null || s.length() == 0 || wordDict.size() == 0) return false;
    //     set = new HashSet<>(wordDict);
    //     return recurse(s);
    // }
    // private boolean recurse(String s) {
    //     // base
    //     if(s.length() == 0) return true;
    //     // logic
    //     for(int i = 0; i < s.length(); i++) { // for loop based recursion
    //         if(set.contains(s.substring(0, i + 1)) && recurse(s.substring(i + 1))) // if in wordDict, then recurse & find for the next part of the string
    //             return true;
    //     }
    //     return false;
    // }

    // DP - we are going to check if at current index i, the substring left to it (j to i - 1) can be formed using the wordDict
    // TC = O(n^2), SC = O(n) - set
    public boolean wordBreak(String s, List<String> wordDict) {
        if(s == null || s.length() == 0 || wordDict.size() == 0) return false;
        HashSet<String> set = new HashSet<>(wordDict);
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for(int i = 0; i < n + 1; i++) {
            for(int j = 0; j < i; j++) { // 0 to j, if the substring can be made by wordDict, in any form, eg substring leet = l+eet or le+e+t or l+eet
                if(dp[j] == true) { // only for the ones that can be formed
                    if(set.contains(s.substring(j, i))) {
                        dp[i] = true; // mark true & break form the inner loop
                        break;
                    }
                }
            }
        }
        return dp[n];
    }
}