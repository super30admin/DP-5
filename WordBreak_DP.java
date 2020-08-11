// Time Complexity : O(n^3) --> where n is the length of input string
// Space Complexity : O(n) 
// Did this code successfully run on Leetcode (139): Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        boolean dp[] = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[dp.length - 1];
    }
}