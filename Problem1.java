// Time Complexity
// Space Complexity

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length(); 
        if(n == 0)  return true;
        boolean[] dp = new boolean[n+1];
        HashSet<String> map = new HashSet<>(wordDict);
        dp[0] = true;
        for(int i=1;i < n+1;i++){
            for(int j=0;j < i;j++){
                if(dp[j] && map.contains(s.substring(j,i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
}
