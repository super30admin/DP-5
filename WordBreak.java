class WordBreak {
    /*
      Brute force
    */
    HashSet<String> set = new HashSet<>();
    public boolean wordBreak(String s, List<String> wordDict) {
        // brut force,
        set = new HashSet<>(wordDict);
        
        
        return helper(s);
    }
    
    private boolean helper(String s){
        
        if(s.length() == 0) return true;
        // logic
        for(int i = 0; i < s.length(); i++){
            if(set.contains(s.substring(0,i+1)) && helper(s.substring(i+1))){
                return true;
            }
        }
        
        return false;
    }
    
    /*
        Time : O(N)
        Space : O(M + N) | M = size of wordDict, N length of a string.
        Leetcode : YES
    */
    
    /*
        Approach : DP
        create a DP array and iterate over it, at every stage check if 0 to i-1 exists in dict or not.
    */
    public boolean wordBreak(String s, List<String> wordDict) {
        if(s == null || s.length() == 0) return false;
        
        HashSet<String> set = new HashSet<>(wordDict);
        boolean [] dp = new boolean[s.length()+1];
        dp[0] = true;
        for(int i = 1; i < dp.length; i++){
            for(int j = 0; j < i ; j++){
                if(dp[j] && set.contains(s.substring(j,i))){
                    dp[i] = true; 
                    break;
                }
            }
        }
                   
        return dp[dp.length - 1];
    }
}
