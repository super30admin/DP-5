import java.util.*;

// tc = O(n^3)
// sc = O(n)
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || s.length() == 0) return true;

        if (wordDict == null || wordDict.size() ==0) return false;

        int n = s.length();
        HashSet<String> set = new HashSet<>(wordDict);

        boolean[] dp = new boolean[n+1];
        dp[0] = true;

        for (int i = 1; i <=n ; i++) {
            for (int j = 0; j <=i; j++) {
                if(dp[j]) {
                    if (set.contains(s.substring(j, i))) {
                        dp[i] = true;
                        break;
                    }
                }
            }
        }

        return dp[n];
    }
}
