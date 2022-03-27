// Time Complexity : O(n^3) ; one 'n' is to check if set contains substring
// Space Complexity : O(n) ; for set
// Did this code successfully run on Leetcode : Yes

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];

        dp[0] = true;
        for(int i= 0; i < dp.length; i++){
            for(int j = 0; j < i; j++){
                if(dp[j] && set.contains(s.substring(j,i))){
                    dp[i] = true;
                    break; //as we dont need to check further
                }
            }
        }
        return dp[s.length()];
    }
}