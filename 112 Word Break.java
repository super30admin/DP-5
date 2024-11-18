// Time Complexity : O(n^2)
// Space Complexity : O(n+m)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    //aesha
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        int n = s.length();
        boolean[] dp = new boolean[n+1];
        dp[0]=true;

        for(int i = 0; i<n+1; i++)
        {
            for(int j = 0; j<i; j++)
            {
                if(dp[j] && set.contains(s.substring(j,i)))
                {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
}