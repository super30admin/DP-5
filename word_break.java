// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        for(int i=1;i<dp.length;i++){
            for(int j=0;j<i;j++){
                String subs = s.substring(j,i);
                if(dp[j] && set.contains(subs)){
                    dp[i]=true;
                    break;
                }
            }
        }
        return dp[dp.length-1];
    }
}