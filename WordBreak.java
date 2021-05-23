// TC - O(n^3)
// SC - O(n)

// LC - 139

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
		// Sanity check
        if(s == null || s.length() == 0){
            return true;
        }
		// Adding elements into set from wordDict
        Set<String> set = new HashSet<>(wordDict);
		// boolean dp array
        boolean[] dp = new boolean[s.length() + 1];
        // As an empty partition is always true, dp[0] will be true
        dp[0] = true;
        // Iterating from 1 to dp.length and j from 0 to i, if dp[j] is true and check if set contains substring(j, i), then dp[i] is true and break
        for(int i=1; i<dp.length; i++){
            for(int j=0; j<i; j++){
                if(dp[j] && set.contains(s.substring(j, i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[dp.length-1];
    }
}