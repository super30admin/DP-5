import java.util.*;

// Approach 1: Recursion and memoization
// Time: O(n^3 + m) where n is length of string and m is size of wordDict
// Space: O(n + m)
public class LC139 {
    HashSet<String> set;

    private boolean explore(String s, int i, int n, int dp[]) {
        // BC
        if (i == n)
            return true;
        if (dp[i] != -1)
            return dp[i] == 1;
        // Logic
        boolean ans = false;
        for (int e = i; e < n; e++) {
            String ss = s.substring(i, e + 1);
            if (set.contains(ss) && explore(s, e + 1, n, dp)) {
                ans = true;
                break;
            }
        }
        dp[i] = ans ? 1 : 0;
        return ans;
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null)
            return false;
        set = new HashSet<>();
        for (String e : wordDict) {
            set.add(e);
        }
        int n = s.length();
        int dp[] = new int[n];
        Arrays.fill(dp, -1);
        return explore(s, 0, n, dp);
    }
}


// Approach 2: Iterative DP
// Time: O(n^3 + m) where n is length of string and m is size of wordDict
// Space: O(n + m)
class LC139_1 {
    HashSet<String> set;

    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null)
            return false;
        set = new HashSet<>();
        for (String e : wordDict) {
            set.add(e);
        }
        int n = s.length();
        boolean dp[] = new boolean[n + 1];
        dp[n] = true;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                String ss = s.substring(i, j + 1);
                if (set.contains(ss) && dp[j + 1]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[0];
    }
}