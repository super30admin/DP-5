import java.util.HashSet;
import java.util.List;

/* recursive approach 
 * The complexity of the algorithm is O(n^n) where  n is length of the string.
 * Space complexity is O(m*n) .
 */

/* DP approach 
 * The complexity of the algorithm is O(n^3) where  n is length of the string.
 * Space complexity is O(n) where n is length of the string .
 */
public class WordBreak {

	HashSet<String> set;

	public boolean wordBreak(String s, List<String> wordDict) {

		if (s.length() == 0 || s == null)
			return false;

		boolean[] dp = new boolean[s.length() + 1];

		set = new HashSet<>(wordDict);
		dp[0] = true;

		for (int i = 0; i < dp.length; i++) {

			for (int j = 0; j <= i; j++) {

				if (dp[j] && set.contains(s.substring(j, i))) {

					dp[i] = true;
					break;
				}

			}

		}

		return dp[dp.length - 1];

	}

	// recursive approach

//	HashSet<String> set;
//
//	public boolean wordBreak(String s, List<String> wordDict) {
//
//		if (s.length() == 0 || s == null)
//			return false;
//
//		set = new HashSet<>(wordDict);
//
//		return helper(s);
//
//	}
//
//	private boolean helper(String s) {
//
//		// base
//		if (s.length() == 0)
//			return true;
//
//		// logic
//
//		for (int i = 0; i < s.length(); i++) {
//
//			if (set.contains(s.substring(0, i + 1)) && helper(s.substring(i + 1))) {
//
//				return true;
//			}
//
//		}
//
//		return false;
//
//	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
