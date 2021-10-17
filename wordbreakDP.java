class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        if(s==null) return false;
        Set<String> set = new HashSet(wordDict);
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        for(int i=0; i< dp.length; i++) {
            for(int j = 0; j<i; j++){
                if(dp[j] && set.contains(s.substring(j,i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[dp.length-1];
    }
}