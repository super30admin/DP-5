// Time Complexity : O(n)
// Space Complexity : O(m + n)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO

import java.util.HashSet;
import java.util.List;

public class WordBreak {
    private HashSet<String> set;
    private boolean[] dp;
    public boolean wordBreak(String s, List<String> wordDict) {
        set = new HashSet<>(wordDict);
        dp = new boolean[s.length() + 1];
        dp[0] = true;
        for(int i =0; i <= s.length(); i++){
            int j = 0;
            while(j < i){
                if(dp[j] == true && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
                j++;
            }
        }
        return dp[dp.length-1];
    }
    
    // private boolean helper(String s){
    //     if(s.length() == 0) return true;
    //     for(int i =0; i< s.length(); i++){
    //         if(set.contains(s.substring(0, i+1)) && helper(s.substring(i+1))) return true;
    //     }
    //     return false;
    // }
    
}