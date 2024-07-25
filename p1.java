class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> hs = new HashSet<>(wordDict);
        
        boolean[] dp = new boolean[s.length()+1];
        int n = s.length();
        dp[0] = true;
        for(int i=1;i<=n;i++){
            for(int j=0;j<i;j++){
                String sub = s.substring(j,i);
                if(dp[j] && hs.contains(sub)){
                    dp[i] = true;
                    break;
                }
                else{

                }
            }
        }
        return dp[n];
        
    }
}