//Time - O(n^3)
//space - O(n)
class Solution {
    private boolean[] dp;
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> dict = new HashSet<>(wordDict);
        dp = new boolean[s.length()+1];
        dp[0] = true;
        for(int i=1; i< dp.length; i++){
            for(int j =0; j<i; j++){
                if(dp[j] && dict.contains(s.substring(j, i))){
                    dp[i] = true;
                    break;
                }
                    
            }
        }
        return dp[dp.length-1];
    }
}