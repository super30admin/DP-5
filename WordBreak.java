// Time Complexity : O(n^3)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        Set<String> set = new HashSet<>(wordDict);
        
        dp[0] = true;
        
        for(int i = 1; i <= s.length(); i++) {
            for(int j = 0; j < i; j++) {
                if(dp[j]) {
                    // System.out.println(s.substring(j, i));
                    if(set.contains(s.substring(j, i))) {
                        dp[i] = true; 
                        break;
                    } 
                }
            }
        }
        return dp[s.length()];
    }
}