//Time complexity: O(n^3), where n is the length of the string
//Space complexity: O(d+n), where d is the length of wordDict list

import java.util.*;

class Solution1 {
    public boolean wordBreak(String s, List<String> wordDict) {
        if(s == null || s.length() == 0 || wordDict == null || wordDict.size() == 0) return false;
        
        Set<String> wordDictSet = new HashSet<>(wordDict);
        
        boolean[] dp = new boolean[s.length()+1]; 
        dp[0] = true;
        
        for(int i=1; i<=s.length(); i++) {
            for(int j=0; j<i; j++) {
                if(dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break; 
                }
            }
        }
        
        return dp[s.length()]; 
    }
}