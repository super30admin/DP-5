// Time Complexity : O(n^4)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        if(wordDict == null || wordDict.size() == 0){
            return false;
        }
        HashSet<String> hs = new HashSet<>(wordDict);
        int n = s.length();
        boolean[] dp = new boolean[n+1];
        dp[0] = true;
        for(int i = 1;i<n+1;i++){
            for(int j =0; j<n+1; j++){
                if(dp[j]){
                    if(hs.contains(s.substring(j,i))){
                        dp[i] = true;
                        break;
                    }
                }
            }
        }
        return dp[n];
    }
}