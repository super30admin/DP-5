## Problem1: (https://leetcode.com/problems/word-break/)

// Time complexity - 0(n^4)
// space complexity - 0(M + n) where M = m * k

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || s.length() == 0) {
            return true;
        }
        HashSet<String> set = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}




## Problem2: (https://leetcode.com/problems/unique-paths/)

// Time complexity - 0(m * n)
// space complexity - 0(n)

class Solution {
    public int uniquePaths(int m, int n) {
        if (m == 0 && n == 0) {
            return 0;
        }
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        for (int i = m - 2; i >= 0; i--) {        // beacuse the last row remains the same with 1's
            for (int j = n - 2; j >= 0; j--) {    // because last value always remains 1
                dp[j] = dp[j] + dp[j + 1];
            }
        }
        return dp[0];     
    }
}