// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*
Use an dp hashset to store boolean if it's a valid split 
*/


// Your code here along with comments explaining your approach
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        if(s==null || s.length()==0) return false;
        HashSet<String> set = new HashSet<>(wordDict);
        boolean [] dp = new boolean[s.length()+1];
        dp[0] = true;
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<i;j++){
                if(dp[j] && set.contains(s.substring(j,i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[dp.length-1];
    }
}
