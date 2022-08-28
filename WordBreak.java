// 0(n^2)
// 0(n)
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        if(wordDict.size()==0 || wordDict== null )
        {
            return false;
        }
        HashSet<String> mp = new HashSet<>(wordDict);
        int n =s.length();
        boolean []dp = new boolean[n+1];
        dp[0]=true;
        for(int i=1;i<n+1;i++)
        {
            for(int j=0;j<i;j++)
            {
                if(dp[j]==true)
                {
                    if(mp.contains(s.substring(j,i)))
                    {
                        dp[i]= true;
                        break;
                    }
                }
            }
        }
        return dp[n];
    }
}