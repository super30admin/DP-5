import java.util.*;

class Solution {
    // Tc: O(n*m*k) where n = length of S; m = length of wordDict; k = Avg lengths
    // of words in wordDict
    // Sc: O(n)
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);

        // Initialize the dp array. dp[i] is True if s.substring(0, i) can be segmented
        // into words in the dictionary
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true; // Empty string can always be segmented

        // Check each substring of s
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                // If s.substring(0, j) can be segmented and s.substring(j, i) is a word, set
                // dp[i] to true
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break; // No need to check further if we found a valid segmentation
                }
            }
        }

        return dp[s.length()];

    }
}