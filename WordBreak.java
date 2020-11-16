// Time Complexity : O(N) - N is length of the string
// Space Complexity : O(N) - As we use a boolean array
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || s.length() == 0) return false;
  
        int n = s.length();
  
       boolean[] dp = new boolean[n];
  
for (int i = 0; i < n; i++) {
    for (int j = 0; j <= i; j++) {
      String sub = s.substring(j, i + 1);
      
      if (wordDict.contains(sub) && (j == 0 || dp[j - 1])) {
        dp[i] = true;
        break;
      }
    }
  }
  
  return dp[n - 1];
    }
}
// Your code here along with comments explaining your approach