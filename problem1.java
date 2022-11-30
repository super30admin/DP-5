package DP-5;

public class problem1 {
    //recursion - expo
    //dp tc - O(n^3)
    public boolean wordBreak(String s, List<String> wordDict) {
        if(s == null || s.length() == 0) return true;
        if(wordDict == null || wordDict.size() == 0) return false;
        
        int n = s.length();
        boolean[] dp = new boolean[n+1];
        HashSet<String> set = new HashSet<>(wordDict);
        dp[0] = true;
        
        for(int i = 1; i <= n; i++){
            for(int j = 0; j < i; j++){
                if(dp[j]){
                    if(set.contains(s.substring(j,i))){
                        dp[i] = true;
                        break;
                    }
                }
            }
        }
        return dp[n];
    }
}
