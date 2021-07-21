// TC: O(n^4)
// SC: O(n)

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        if(s == null || s.length() == 0) {
            return false;
        }
        HashSet<String> set = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        int i, j;
        dp[0] = true;
        for(i = 1; i < dp.length; i++) {
            for(j = 0; j < i; j++) {
                if(dp[j] == true && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[dp.length - 1];
    }
}