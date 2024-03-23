import java.util.HashSet;
import java.util.List;
import java.util.Set;

class WordBreak {
    Set<String> set;
    int[] dp;

    // TC: O(n ^ 3)
    // SC: O(n)

    // Approach: Try all possible paths and if you find a word in dictionary
    // and if there's a match with the dictionary, explore that path.
    // if you reach at the end; return true for that index.

    public boolean wordBreakDFS(String s, List<String> wordDict) {
        this.set = new HashSet<>();
        // 1 means true (s can be formed at this index)
        // 2 means false
        dp = new int[s.length()];

        for (String x : wordDict) {
            set.add(x);
        }

        return dfs(0, s);
    }

    public boolean dfs(int pivot, String s) {
        if (pivot == s.length()) {
            return true;
        }

        if (dp[pivot] != 0) {
            if (dp[pivot] == 1) {
                return true;
            }
            return false;
        }

        for (int i = pivot; i < s.length(); i++) {
            String sub = s.substring(pivot, i + 1);
            if (set.contains(sub)) {
                if (dfs(i + 1, s)) {
                    dp[pivot] = 1;
                    return true;
                }
            }
        }

        dp[pivot] = 2;
        return false;
    }

    public boolean wordBreakTabulation(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        Set<String> set = new HashSet<>();

        for (String x : wordDict) {
            set.add(x);
        }

        // empty string can be formed
        dp[s.length()] = true;

        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i; j < s.length(); j++) {
                String sub = s.substring(i, j + 1);
                if (set.contains(sub) && dp[j + 1]) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[0];
    }
}
