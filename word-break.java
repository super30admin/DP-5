// Time Complexity : O(n^4), n -> Length of string
// Space Complexity : O(max(m,n)), m -> Number of characters in the dictionary, n -> Length of string
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || s.length() == 0 || wordDict == null || wordDict.size() == 0) {
			return false;
		}
        
        Set<String> set = new HashSet<>(wordDict);        
        int n = s.length();
        boolean[] dp = new boolean[n+1];
        dp[0] = true;
        for(int i=1; i<=n; i++) {
            for(int j=0; j<i; j++) {
                if(dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
}