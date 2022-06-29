//https://leetcode.com/problems/word-break/
// Time Complexity :O(l*l*l)  
// Space Complexity :O(l)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set=new HashSet<>(wordDict);
        boolean[] dp=new boolean[s.length()+1];
        dp[0]=true;
        for(int i=1;i<dp.length;i++)
        {
            for(int j=0;j<i;j++)
            {
                if(dp[j] && set.contains(s.substring(j,i)))
                {
                    dp[i]=true;
                    break;
                }
            }
        }
        return dp[dp.length-1];
        
    }
}