/*
Time:O(n^3) - including substring creation
Space: O(n)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : None
*/
public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n + 1]; // java substring ending index is exclusive

        dp[0] = true; // empty string is always inclued in any dict

        int maxLen = 0;

        // Find the max length from the wordDict
        for (String word : wordDict) {
            maxLen = Math.max(maxLen, word.length());
        }

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                // optimization
                if (i - j > maxLen) {
                    continue; // ignore
                }

                if (dp[j] && wordDict.contains(s.substring(j, i))) // dp[j] is true and substring is also found at i
                {
                    dp[i] = true; // mark i as true and break out
                    break;
                }
            }
        }
        return dp[n];
    }

}
