import java.util.*;

class Solution {

    /**
    Time Complexity : O(N^2 * L)
    Explanation:
    - Outer loop runs N times
    - Inner loop runs up to N times
    - substring(j, i) takes O(L) time (L = length of substring)
    So total ≈ O(N^2 * L)

    Space Complexity : O(N)
    Explanation:
    DP array of size N+1 and HashSet for dictionary.

    Did this code successfully run on LeetCode : Yes

    Any problem you faced while coding this :
    Initially confused about how to build valid substrings step by step.
    Fixed it using DP:
        dp[i] = true → substring [0, i) can be formed
    Then checked:
        if dp[j] == true AND s[j:i] exists in dictionary
    Also used HashSet for O(1) lookup.
    */

    public boolean wordBreak(String s, List<String> wordDict) {

        HashSet<String> set = new HashSet<>();

        // Store dictionary for fast lookup
        for (String word : wordDict) {
            set.add(word);
        }

        int n = s.length();

        boolean[] dp = new boolean[n + 1];

        // Base case: empty string
        dp[0] = true;

        for (int i = 1; i <= n; i++) {

            for (int j = 0; j < i; j++) {

                if (dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n];
    }
}