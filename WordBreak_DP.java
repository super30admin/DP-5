//TC: O(n^3)
//SC: O(n) n is length of HAshset

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        
        HashSet<String> set = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for(int i = 0; i < dp.length ; i++){ //iterating on dp
            for(int j = 0; j < i; j++){ //iterating on substring L, LE, LEE, etc
                if(dp[j] && set.contains(s.substring(j,i)) ){
                    dp[i] = true;
                    break;
                }
            }
            
        }
        return dp[s.length()];
    }
}