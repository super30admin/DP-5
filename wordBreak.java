// Time: O(n^4) where n is length of string s
//Space: O(k) where k is average length of words in wordDict

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        if(s == null) return false;
        HashSet<String> set = new HashSet<>(wordDict);
        int n = s.length();
        boolean[] dp = new boolean[n+1];
        dp[0] = true;
        for(int i=1; i<dp.length; i++){
            for(int j=0; j < i; j++){
                if(dp[j] && set.contains(s.substring(j,i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[dp.length-1];
    }
}