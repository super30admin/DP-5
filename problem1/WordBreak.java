// Time Complexity : O(n^4), n -> Length of string
// Space Complexity : O(max(m,n)), m -> Number of characters in the dictionary, n -> Length of string
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
package problem1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {
	/********************* Brute Force *********************/
	// Time Complexity : O(n^n) n -> Length of String
	// Space Complexity : O(n), Recursive Stack
	// Did this code successfully run on Leetcode : Time Limit Exceeded
	// Any problem you faced while coding this : No
	public boolean wordBreakBruteForce(String s, List<String> wordDict) {
		if (s == null || s.length() == 0 || wordDict == null || wordDict.size() == 0) {
			return false;
		}

		Set<String> wordSet = new HashSet<>(wordDict);

		return helper(s, wordSet);
	}

	private boolean helper(String s, Set<String> wordSet) {
		// Base
		if (s.equals("")) {
			return true;
		}
		// Logic
		for (int i = 0; i < s.length(); i++) {
			if (wordSet.contains(s.substring(0, i + 1)) && helper(s.substring(i + 1), wordSet)) {
				return true;
			}
		}
		return false;
	}

	/********************* Dynamic Programming *********************/
	// Time Complexity : O(n^4), n -> Length of string
	// Space Complexity : O(max(m,n)), m -> Number of characters in the dictionary, n -> Length of string
	// Did this code successfully run on Leetcode : Yes
	// Any problem you faced while coding this : No
	public boolean wordBreak(String s, List<String> wordDict) {
		if (s == null || s.length() == 0 || wordDict == null || wordDict.size() == 0) {
			return false;
		}

		int n = s.length();
		boolean[] dp = new boolean[n + 1];
		dp[0] = true;

		for (int i = 1; i <= n; i++) {
			for (int j = 0; j < i; j++) {
				if (dp[j] && wordDict.contains(s.substring(j, i))) {
					dp[i] = true;
					break;
				}
			}
		}
		return dp[n];
	}

	public static void main(String[] args) {
		WordBreak obj = new WordBreak();
		String s = "leetcode";
		List<String> wordDict = new ArrayList<>(Arrays.asList("leet", "code"));

		System.out.println("Can the word \'" + s + "\' be formed using the given dictionary words? "
				+ (obj.wordBreak(s, wordDict) == true ? "Yes" : "No"));
	}

}
