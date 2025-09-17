//TC: O(n²) for the DP checks.
//SC: O(n) auxiliary for the DP array (excluding the dictionary set).

//dp[i] = can the prefix s[0..i) be segmented.
//For each i, scan j < i; if dp[j] is true and s[j..i) is in the set, mark dp[i]=true and break.
//Initialize dp[0]=true; answer is dp[n].

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        int n = s.length();

        boolean[] dp = new boolean[n + 1];

        dp[0] = true;
        
        for(int i = 1; i <= n; i++){
            for(int j = 0; j < i; j++){
                if(dp[j] && set.contains(s.substring(j, i))){
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n];
    }
}
