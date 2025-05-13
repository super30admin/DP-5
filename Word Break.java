public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        int n = s.length();
        boolean[] dp = new boolean[n + 1]; // dp[i] is true if s[0..i-1] can be segmented
        dp[0] = true; // Base case: empty string

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                // Check if substring s[j..i-1] is in the dictionary
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n];
    }
}

/*
Time Complexity: O(n^2)
Space Complexity: O(n + m)
*/