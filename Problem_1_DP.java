// Time complexity - O(n^3)
// Space complexity - O(n)


class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        if(s == null || s.length() == 0) return true;
        Set<String> set = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for(int i = 0 ; i < dp.length; i++){
            for(int j = 0 ; j < i ; j++){
                if(dp[j] && set.contains(s.substring(j,i))){
                    dp[i] = true;
                }
            }
        }
        return dp[dp.length - 1];
    }
}
