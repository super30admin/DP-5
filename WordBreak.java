/* 
Time Complexity: O(n^2)
   - For each i (1..n), inner loop runs up to i → O(n^2).

Space Complexity: O(n)
   - dp array of size n+1.
   - HashSet of dictionary words is O(k), where k = number of words.

Did this code successfully run on Leetcode: Yes
*/

// Approach:
// - dp[i] = true if s[0..i) can be segmented into dictionary words.
// - Initialize dp[0] = true (empty string is valid).
// - For each i from 1..n:
//     * Check all partitions j < i.
//     * If dp[j] is true and s[j..i) is in dictionary, set dp[i] = true and break.
// - Final answer = dp[n], meaning full string can be segmented.


import java.util.HashSet;
import java.util.List;

public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        HashSet<String> set = new HashSet<>(wordDict);

        boolean[] dp = new boolean[n+1];
        dp[0] = true;

        for(int i = 1; i <= n; i++){
            for(int j = 0; j < i; j++){
                if(dp[j] && set.contains(s.substring(j, i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
}
