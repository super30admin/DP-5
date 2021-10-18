// Time Complexity : O(m * n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        // null
        if(s == null) return false;
        HashSet<String> set = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        for(int i=0; i<dp.length; i++){
            for(int j=0; j<i; j++){
                if(dp[j] && set.contains(s.substring(j, i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[dp.length-1];
    }
}