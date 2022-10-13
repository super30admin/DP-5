class Solution {
    //tc - n^3
    //sc - ml + n(m being avg size of word in dic and n is tot no of words + n is len of dp array)
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        //total sc -n3
        for(int i=0;i<dp.length;i++)//here n2
        {
            for(int j=0;j<i;j++)
            {
                if(dp[j] == true && set.contains(s.substring(j,i)))//n for finding substr
                {
                  dp[i] = true;
                  break;
                }
            }
        }
        return dp[s.length()];
    }
}