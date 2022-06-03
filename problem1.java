class wordBreak1 {
    public boolean wordBreak(String s, List<String> wordDict) {
        if(s == null || s.length() == 0) return false;
        
        HashSet<String> set = new HashSet(wordDict);
        
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        
        for(int i = 1; i <= s.length(); i++){
            for(int j = 0; j < i; j++){
                if(dp[j]){
                    String sub = s.substring(j, i);
                    if(set.contains(sub)){
                        dp[i] = true;
                        break;
                    }
                }
            }
        }
        return dp[s.length()];
    }
}

//O(n^3 + m) where m is time for adding wordDict to hashset and n is for loop 
//O(m + n) where m is hashset space and n is for DP array space