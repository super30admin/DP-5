//Time complexity is O(n^2)
//Space complexity is O(n)
//This solution is submitted on leetcode

import java.util.HashSet;
import java.util.List;

public class BigN108WordBreakDPSolution {
	class Solution {
		public boolean wordBreak(String s, List<String> wordDict) {
			// egde case
			if (s == null || s.length() == 0)
				return false;
			HashSet<String> set = new HashSet<>(wordDict);
			boolean[] dp = new boolean[s.length() + 1];
			dp[0] = true;
			for (int i = 0; i < dp.length; i++) {
				for (int j = 0; j < i; j++) {
					if (dp[j] && set.contains(s.substring(j, i)))
						dp[i] = true;
				}
			}
			return dp[s.length()];
		}
	}
}