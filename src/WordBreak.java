import java.util.List;
//Time Complexity : O(N^3) 
//Space Complexity : O(N) 
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

/**
 * Take a boolean dp array. Iterate from 0 to end of the string to find
 * substrings. If a substring is present in the list, then apply the same logic
 * on the rest of the string to find the other words from the list and return
 * true, else false.
 *
 */
class Solution {
	public boolean wordBreak(String s, List<String> wordDict) {
		Boolean[] dp = new Boolean[s.length() + 1];
		return helper(s, dp, 0, wordDict);
	}

	public boolean helper(String s, Boolean[] dp, int start, List<String> words) {
		if (start == s.length())
			return true;
		if (dp[start] != null)
			return dp[start];
		for (int end = start + 1; end <= s.length(); end++) {
			if (words.contains(s.substring(start, end)) && helper(s, dp, end, words))
				return dp[start] = true;
		}

		return dp[start] = false;
	}
}
