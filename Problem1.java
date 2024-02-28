class Solution {
    //TC: O(n *l + n^3)
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        int n = s.length();
        boolean [] dp = new boolean[n+1];
        dp[0] = true;
        for(int i = 1; i <= n; i++){
            for(int j = 0; j < i; j++){
                if(dp[j] & set.contains(s.substring(j,i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
}
