class Problem139 {
    public boolean wordBreak(String s, List<String> wordDict) {
      Set<String> set = new HashSet<>(wordDict);
        
        boolean[] dp = new boolean[s.length()+1];
        
        dp[0] = true;
        
        for(int index = 1; index <= s.length();index++){
            for(int j = 0; j < index; j++){
                if(dp[j] && set.contains(s.substring(j,index))){
                    dp[index]=true;
                    break;
                }
            }
            
        }
        return dp[s.length()];
    }   
}
