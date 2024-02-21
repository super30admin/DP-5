/*
* Did this code successfully run on Leetcode : YES
* 
* Any problem you faced while coding this : NO
* 
* Time Complexity: O(n*l + l^3)
* 
* Space Complexity: O(n*l)
* 
*/

import java.util.HashSet;
import java.util.List;

public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> wordSet = new HashSet<>(wordDict);

        int n = s.length();

        boolean[] dp = new boolean[n + 1];

        dp[0] = true;

        for (int index = 0; index <= n; index++) {
            int j = 0;

            while (j < index) {
                if (dp[j] && wordSet.contains(s.substring(j, index))) {
                    dp[index] = true;
                    break;
                }
                j++;
            }
        }

        return dp[n];
    }
}
