//Time: O(n^2)
//Space: O(n + k)
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
     Set<String> wordSet = new HashSet<>(wordDict);  // Convert the list to a set for O(1) lookups
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;  // Base case: an empty string can always be segmented

        // Iterate over the string
        for (int i = 1; i <= n; i++) {
            // Check all substrings s[j:i]
            for (int j = 0; j < i; j++) {
                // If s[0:j] can be segmented and s[j:i] is in the dictionary
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;  // No need to check further if we found a valid segmentation
                }
            }
        }

        return dp[n];  // dp[n] indicates whether the entire string can be segmented
    }
}
