public class WordBreak1 {
/**
 * Time complexity: O(N^2) where N is length of string
 * Space complexity: O(N + S) where N is length of string, S is size of words list
 * 
 * Approach:
 * 1. 
 */

    public boolean wordBreak(String s, List<String> wordDict) {
        
        Set<String> set = new HashSet<>();
        
        for(String w: wordDict) {
            set.add(w);
        }
        
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        
        for(int i=1; i<=s.length(); i++) {
            for(int j=0; j<i; j++) {
                if(dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                }
            }
        }
        
        return dp[s.length()];
        
    }
}