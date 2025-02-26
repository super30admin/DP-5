import java.util.HashSet;
import java.util.List;

/**
 * Time Complexity: O(n^3)
 * Space Complexity: O(n)
 * Did this code successfully run on Leetcode: Yes
 * Any problem you faced while coding this: None

 * Approach:
 * 
 */

public class WordBreak {
     HashSet<String> set;
    public boolean wordBreak(String s, List<String> wordDict) {
        if(s == null || s.length() == 0 || wordDict.isEmpty()) {
            return false;
        }
        set = new HashSet(wordDict);
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for(int i = 1; i < n + 1; i++) {
            for(int j = 0; j < i; j++) {
                if(dp[j] == true) {
                    if(set.contains(s.substring(j, i))) {
                        dp[i] = true;
                        break;
                    }                    
                }
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        // Your code here
    }
}