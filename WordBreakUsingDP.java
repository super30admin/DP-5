// Time Complexity : O(n^3) -> n is the length of the string
// Space Complexity : O(n*l) + O(n)
// Did this code successfully run on Leetcode : Yes


import java.util.HashSet;
import java.util.List;

public class WordBreakUsingDP {

    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        int n = s.length();
        boolean[] dp = new boolean[n+1];
        dp[0] = true;

        for(int i=1; i<=n; i++)
        {
            for(int j=0; j<i; j++)
            {
                String sub = s.substring(j,i);
                if(dp[j] && set.contains(sub))
                {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n];

    }
}