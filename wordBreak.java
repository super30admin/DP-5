//TC: n^3 --> i,j and iterating on each substring
//SC: n + m*l --> n- length of dp, m- set, -avg length of each work
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        for(int i=0;i<dp.length;i++){
            for(int j=0; j<i;j++){
                if(dp[j] == true && set.contains(s.substring(j,i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
