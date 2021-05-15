// Time Complexity : O(N^3)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length()+1];
        HashSet<String> wordSet = new HashSet<>(wordDict);
        dp[0] = true;
        for(int i = 1 ; i <= s.length() ; i++){
            for(int j = 0 ; j < i ; j++){
                String sub = s.substring(j,i);
                if(dp[j] && wordSet.contains(sub)){
                    dp[i] = true;
                    break;    
                }
            }
        }
        return dp[s.length()];
    }
}
