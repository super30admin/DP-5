//Time = O(n^2)
//Space = O(n)


class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length(); // Get the length of the input string
        boolean[] dp = new boolean[n+1]; // Initialize a boolean array of length n+1 to store intermediate results
        dp[0] = true; // Set dp[0] to true since the empty string can always be broken down into valid words

        // Loop through each character of the input string
        for (int i = 1; i <= n; i++) {
            // Loop through each word in the word dictionary
            for (String word : wordDict) {
                int len = word.length();
                // Check if the current word in the dictionary matches the substring of s starting at i-len
                if (len <= i && word.equals(s.substring(i-len, i))) {
                    dp[i] = dp[i] || dp[i-len]; // Update dp[i] to be true if the substring ending at i-len can be broken down into valid words
                }
            }
        }

        return dp[n]; // Return dp[n], which stores whether the entire string can be broken down into valid words
    }
}
