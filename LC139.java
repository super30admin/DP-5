//Time Complexity : O(n^3)
//Space Complexity : O(n^l)

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        
        HashSet<String> hs = new HashSet<>(wordDict);
        
        boolean dp[] = new boolean[s.length()+1];
        
        dp[0] = true;
        
        for(int i=0;i<=s.length();i++)
        {
            for(int j=0;j<i;j++)
            {
                if(dp[j] && hs.contains(s.substring(j,i)))
                {
                    dp[i] = true;
                    break;
                }
            }
        }
        
        return dp[s.length()];
    }
}