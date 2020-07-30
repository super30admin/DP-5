
//TC - O(N^2 * L)
//SC - O(word_dict)
import java.util.*;

class Solution1 {
	public boolean wordBreak(String s, List<String> wordDict) {
		if (s.length() == 0)
			return true;
		HashSet<String> set = new HashSet<>(wordDict);
		boolean[] dp = new boolean[s.length() + 1];
		dp[0] = true;
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < i; j++) {
				if (dp[j] && set.contains(s.substring(j, i))) {
					dp[i] = true;
				}
			}
		}
		return dp[dp.length - 1];
	}
}