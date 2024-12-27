// Time Complexity : O(n^3)
// Space Complexity : O(n + k), n-dp array, k-hashset
// Did this code successfully run on Leetcode : Yes


// Your code here along with comments explaining your approach

class Solution {
  public boolean wordBreak(String s, List<String> wordDict) {
    if(s == null || s.length() == 0) return true;
    Set<String> set = new HashSet<>(wordDict);
    int n = s.length();
    boolean[] dp = new boolean[n+1];
    dp[0] = true;
    for(int i = 1; i<n+1; i++) {
      for(int j = 0; j<i; j++) {
        // Only if dp[j] is true and the previous elements are in the dictionary
        if(dp[j] && set.contains(s.substring(j,i))) {
          dp[i] = true;
          break;
        }
      }
    }
    return dp[n];
  }
}