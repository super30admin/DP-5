//TC: O(n^2)
//SC: O(N) //length of word dictionary for set

import java.util.*;

class wordBrake {
    public boolean wordBreak(String s, List<String> wordDict) {
        if(s == null || s.length() == 0){
            return false;
        }
        
        Set<String> set = new HashSet<>(wordDict);
        
        int n = s.length();
        
        boolean[] dp = new boolean[n + 1];
        
        //start off by setting empty string to true
        dp[0] = true;
        
        for(int i = 1; i <= n; i++){
            for(int j = 0; j < i; j++){
                if(dp[j] && set.contains(s.substring(j, i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
        
    }

}