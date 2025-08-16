//TimeC:O(n^2)
//SC:O(n)
	import java.util.*;

	class Solution2 {
	    public boolean wordBreak(String s, List<String> wordDict) {
	        Set<String> dict = new HashSet<>(wordDict);
	        int n = s.length();
	        boolean[] dp = new boolean[n + 1];
	        dp[0] = true;

	        // Optional pruning: track max word length
	        int maxLen = 0;
	        for (String w : dict) maxLen = Math.max(maxLen, w.length());

	        for (int i = 1; i <= n; i++) {
	            // j only needs to look back up to maxLen
	            int start = Math.max(0, i - maxLen);
	            for (int j = start; j < i; j++) {
	                if (dp[j] && dict.contains(s.substring(j, i))) {
	                    dp[i] = true;
	                    break;
	                }
	            }
	        }
	        return dp[n];
	    }
	}