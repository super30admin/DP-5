//tc O(n3)
//sc O(n)
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[s.length()] = true;
        for (int i = s.length() - 1; i >= 0; i--) {
            for (String word : wordDict) {
                int len = word.length();
                if (i + len <= s.length() && s.substring(i, i + len).equals(word)) {
                    dp[i] = dp[i + len];                    
                }
                if (dp[i]) {
                    break;
                }
            }
        }
        return dp[0];
    }
}