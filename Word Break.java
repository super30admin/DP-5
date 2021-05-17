// Time Complexity :O(n^2)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

class Solution {
  public boolean wordBreak(String s, List<String> wordDict) {
    if (s == null || s.length() == 0)
      return true;

    boolean[] dp = new boolean[s.length() + 1];
    dp[0] = true;
    HashSet<String> set = new HashSet<>(wordDict);

    for (int i = 0; i < dp.length; i++) {
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