// Time Complexity : O(n^2) where n is the length of the string s
// Space Complexity : O(n) to store words in the array
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class wordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int j = 0; j <= n; j++) {
            for (int i = 0; i < j; i++) {
                if (dp[i] && set.contains(s.substring(i, j))) {
                    dp[j] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
}