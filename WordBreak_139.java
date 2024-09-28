package dp5;

// Idea: Take two pointers and start from first two letters of string. Move i one by one, move j form 0 till i in each iteration to check if 
// the substring obtained till now is in word dictionary or not. 
// If found, mark dp[i] as true and start j from 0. If we find true at the end of the string, our word break is possible.

// TC: O(s^2) where s is the length of the string. [set.contains() is constant]
// SC: O(n) where n is the length of word dictionary.

import java.util.HashSet;
import java.util.List;

public class WordBreak_139 {
 
    public boolean wordBreak(String s, List<String> wordDict) {
    boolean[] dp = new boolean[s.length() + 1];
    HashSet<String> set = new HashSet<>(wordDict);
    dp[0] = true;
        for(int i = 1; i <= s.length(); i++){
            for(int j = 0; j < i; j++) { 
                if(dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
    
    
    
    //BRUTE FORCE - Time Limit Exceeded
    //TC: O(2^n) because of the && operator 
    /*
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        
        return helper(s, set);
    }
    public boolean helper(String s, HashSet<String> set ) {
        if(s.length() == 0) return true;
        
        for(int i = 0; i <= s.length(); i++){
            if(set.contains(s.substring(0, i)) && helper(s.substring(i), set)) {
                return true;
            }
        }
        return false;
    }
   */ 
	
}
