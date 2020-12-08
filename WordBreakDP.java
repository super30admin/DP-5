package Dec8;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

class WordBreakDP {
    Set<String> set;
    
    public boolean wordBreak(String s, List<String> wordDict) {
        // edge
        if (s == null || s.length() == 0) {
            return false;
        }
        set = new HashSet<>(wordDict);
        // last element of dp array will tell if characters before the same in the given string can form valid substrings or not which are present in word dictionary. 
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i < dp.length;i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && set.contains(s.substring(j,i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        
        return dp[dp.length-1];
    }    
}