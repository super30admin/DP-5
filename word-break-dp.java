import java.util.*;

class Solution {
    // DP Solution
    // Time complexity is O(L^3)
    // Space complexity is O(L+1)
    // This solution is submitted with zero errors
    HashSet<String> set;
    public boolean wordBreak(String s, List<String> wordDict) {
        // Edge case
        if(s == null || s.length() == 0) return false;
        set = new HashSet<>(wordDict);
        boolean [] dp = new boolean[s.length()+1];
        dp[0] = true;
        for(int i= 1; i<dp.length; i++){ // l
            for(int j = 0; j< i; j++){ // l
                String sub = s.substring(j,i); // l
                if(dp[j] && set.contains(sub)){
                    // Actually to find string in set is l since we need to calculate iterate
                    // and find asci value but we ignore
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}