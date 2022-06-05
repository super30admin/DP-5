//TC : O(M + N^3)
//SC : O(M+N)
class Solution {
    boolean possible;
    public boolean wordBreak(String s, List<String> wordDict) {
        if(s==null||s.length()==0) return true;
        HashSet<String> hs = new HashSet(wordDict);

        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;

        for(int i=1;i<=s.length();i++)
        {
            for(int j=0;j<i;j++)
            {
                if(dp[j])
                {
                    String sub = s.substring(j,i);
                    if(hs.contains(sub))
                    {
                        dp[i] = true;
                        break;
                    }
                }
            }
        }
        return dp[s.length()];
    }
}