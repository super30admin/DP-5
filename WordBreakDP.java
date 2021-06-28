package DP5;

import java.util.HashSet;
import java.util.List;

/*
        -------------------------------------------------------------------------------------------------------
        Time complexity : o(n*n)
        space complexity: o(n)
        Did this code run successfully in leetcode : yes
        problems faces : no
 */

public class WordBreakDP {

    public boolean wordBreak(String s, List<String> wordDict) {

        if (s == null || s.length() == 0)
            return false;

        HashSet<String> set = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[dp.length - 1];

    }
}
