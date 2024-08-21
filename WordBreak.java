/**
 * Time Complexity: O(n * k), where n is the length of the string `s` and k is the maximum length of words in the word dictionary.
 * The algorithm iterates through each character of the string and, for each character, checks substrings of length up to `k` 
 * to see if they are present in the dictionary.

 * Space Complexity: O(n), where n is the length of the string `s`.
 * The space complexity is determined by the boolean DP array `dp` of size `n + 1` and the HashSet used to store words from the dictionary.
 */
class Solution {

    // Main function to determine if the string can be segmented into words from the wordDict
    public boolean wordBreak(String s, List<String> wordDict) {

        // Convert the word dictionary into a HashSet for quick lookup
        HashSet<String> wordSet = new HashSet<>();
        int minWordLength = Integer.MAX_VALUE;
        int maxWordLength = 0;

        // Track minimum and maximum word lengths in the dictionary
        for (String word : wordDict) {
            wordSet.add(word);
            minWordLength = Math.min(minWordLength, word.length());
            maxWordLength = Math.max(maxWordLength, word.length());
        }

        // Create a boolean array dp where dp[i] represents if the substring s[0:i] can be segmented
        boolean[] dp = new boolean[s.length() + 1];

        // Base case: an empty string can always be segmented
        dp[0] = true;

        // Iterate through the string and fill the dp array
        for (int i = 1; i < dp.length; i++) {
            // Only check substrings within valid word length range
            for (int j = Math.max(0, i - maxWordLength); j <= i - minWordLength; j++) {
                String partSubstring = s.substring(j, i);

                // If dp[j] is true and partSubstring is in the wordSet, set dp[i] to true
                if (dp[j] && wordSet.contains(partSubstring)) {
                    dp[i] = true;
                    break;  // No need to check further substrings for this index
                }
            }
        }

        // The last element in dp array represents if the entire string can be segmented
        return dp[dp.length - 1];
    }
}
