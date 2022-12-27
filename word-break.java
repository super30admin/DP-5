import java.util.*;

//tc is O(n^3) since two loops and substring also takes n so n^3
//sc is O(m + n) word dictionary and array and substring
class Solution {
    HashSet<String> set;

    public boolean wordBreak(String s, List<String> wordDict) {

        if (wordDict == null || wordDict.size() == 0)
            return false;
        set = new HashSet<>(wordDict);
        int n = s.length();

        boolean[] dp = new boolean[n + 1];

        dp[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j]) {
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