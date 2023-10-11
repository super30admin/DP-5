 //TC:O(n^2)

 class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean [] dp = new boolean [s.length() + 1];
        HashSet <String> set = new HashSet<>(wordDict);
        dp[0] = true;
        for(int i = 1; i < dp.length; i++){
            for(int j = 0; j < i; j++){
                if(dp[j] && set.contains(s.substring(j,i))){
                    dp[i] = true;
                }
            }
        }
        return dp[dp.length - 1];
    }
} 