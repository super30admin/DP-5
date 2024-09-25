class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        if(s.length() == 0 || s == null) return false;
        
        HashSet set = new HashSet<>(wordDict);
        
        boolean [] dp =  new boolean[s.length() +1];
        
        dp[0] = true;
        
        for(int i = 1; i< dp.length; i++){
            for(int j = 0; j<i; j++){
                if(dp[j] && set.contains(s.substring(j,i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[dp.length-1];
        
    }
}

//TC: O(N^2)
//SC: O(N)
