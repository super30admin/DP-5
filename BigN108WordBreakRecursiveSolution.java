//Time complexity is O(m^n)
//Space complexity is O(m^n)
//This solution is submitted on leetcode

import java.util.HashSet;
import java.util.List;

public class BigN108WordBreakRecursiveSolution {
	class Solution {
		HashSet<String> set;

		public boolean wordBreak(String s, List<String> wordDict) {
			set = new HashSet<>(wordDict);
			return helper(s);
		}

		private boolean helper(String s) {
			// base case
			if (s.length() == 0)
				return true;
			// logic
			for (int i = 0; i <= s.length(); i++) {
				if (set.contains(s.substring(0, i)) && helper(s.substring(i)))
					return true;
			}
			return false;
		}
	}
}