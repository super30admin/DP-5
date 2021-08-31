//Solution 1
// Time Complexity : O(N^N) n -> Length of String
// Space Complexity : O(N), Recursive Stack Space
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || s.length() == 0 || wordDict == null || wordDict.size() == 0) {
            return false;
        }

        Set<String> wordSet = new HashSet<>(wordDict);

        return helper(s, wordSet);
    }
    private boolean helper(String s, Set<String> wordSet) {
        // Base
        if (s.equals("")) {
            return true;
        }
        // Logic
        for (int i = 0; i < s.length(); i++) {
            if (wordSet.contains(s.substring(0, i + 1)) && helper(s.substring(i + 1), wordSet)) {
                return true;
            }
        }
        return false;
    }
}

//Solution2 : DP
// Time Complexity : O(N^4), N -> Length of string
// Space Complexity : O(max(M,N)), M -> No of chars in the dictionary, N -> Length of string
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || s.length() == 0 || wordDict == null || wordDict.size() == 0) {
            return false;
        }

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
}