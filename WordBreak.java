// Time Complexity : O(N pow 3)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


/*
 * 1. DP solution.
 * 2. For each character check is dictionary contains word or not and mark with boolean value.
 * 3. if not contains find previous true in the dp array and check substring from there to current index.
 * 4. last index in dp array will contains final result. 
 */

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {
	public boolean wordBreak(String s, List<String> wordDict) {

		Set<String> dictSet = new HashSet<>(wordDict);
		boolean[] dp = new boolean[s.length() + 1];
		dp[0] = true;

		for (int i = 1; i < dp.length; i++) {
			for (int j = 0; j < i; j++) {
				if (dp[j] && dictSet.contains(s.substring(j, i))) {
					dp[i] = true;
					break;
				}
			}
		}
		return dp[dp.length - 1];
	}
}
