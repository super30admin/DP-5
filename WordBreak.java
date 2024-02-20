import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        return wordBreakMemoization(s, wordDict);
    }

    // TC: O(N ^ 3) where N is length of String
    // SC: O(N)
    private boolean wordBreakDP(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }

    Map<String, Boolean> memo = new HashMap<>();

    // TC: O(N ^ 3) where N is length of String
    // SC: O(N)
    private boolean wordBreakMemoization(String s, List<String> wordDict) {
        return helper(s, wordDict);
    }

    private boolean helper(String s, List<String> wordDict) {
        if (s.length() == 0) return true;
        if (memo.containsKey(s)) return memo.get(s);
        for (int i = 0; i < s.length(); i++) {
            String sub = s.substring(0, i + 1);
            if (wordDict.contains(sub) && helper(s.substring(i + 1), wordDict)) {
                memo.put(s, true);
                return true;
            }
        }
        memo.put(s, false);
        return false;
    }
}
