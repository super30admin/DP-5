//time complexity O(n^2)
//space complexity O(n+1) size of dp array

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        if(s == null) return false;
        HashSet<String> set = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for(int i = 0; i < dp.length; i++){
            for(int j = 0; j < i; j++){
                if(dp[j] == true && set.contains(s.substring(j, i))){
                    dp[i] = true;
                }
            }
        }
        return dp[dp.length - 1];
    }
}
