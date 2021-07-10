// Time Complexity : O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this :No
public class Solution {
    HashSet<String> map;
    public boolean wordBreak(String s, List<String> wordDict) {
        map = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        for(int i = 1;i <=s.length();i++)
        {
            for(int j = 0;j <i;j++)
            {
                if(dp[j] && map.contains(s.substring(j,i)))
                {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}