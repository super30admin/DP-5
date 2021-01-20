// Time - O(N^2)
// Space - O(N)
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        
        if(wordDict.size()==0) {
            return false;
        }
        
        boolean[] dp = new boolean[s.length()+1];
        
        dp[0] = true;
        
        for(int i=1;i<=s.length();i++) {
            for(int j=0;j<i;j++) {
                if(dp[j] && wordDict.indexOf(s.substring(j, i)) >= 0) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
