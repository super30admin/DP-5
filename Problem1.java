package DP_5;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * Using top up dynamic programming where we find all possible combinations
 * where the word can be broken such that the first part is in the given list.
 * Then we recursively check for the rest of the string similarly and memoize
 * these results on the go.
 * 
 * Time Complexity : O(L)^L- where L is the length of the given string
 * 
 * Space Complexity : O(L)^L, as we memoize the results at each point.
 * 
 * Did this code successfully run on Leetcode : yes
 * 
 * Any problem you faced while coding this : No
 */
public class Problem1 {
	HashMap<String, Boolean> memoization;

	public boolean wordBreak(String s, List<String> wordDict) {
		memoization = new HashMap<>();
		HashSet<String> map = new HashSet<>(wordDict);
		boolean flag = helper(s, map, 0);
		return flag;
	}

	private boolean helper(String s, HashSet<String> map, int idx) {

		if (s.length() == idx)
			return true;

		// logic
		for (int i = idx; i < s.length(); i++) {
			String prefix = s.substring(idx, i + 1);

				if (!map.contains(prefix)) {
					continue;
				} else {
                    if(memoization.get(s.substring(i + 1))==null){
                    boolean flag = false;
					flag = helper(s, map, i + 1);
					memoization.put(s.substring(i + 1), flag);
                    }
                    if(memoization.get(s.substring(i + 1)))
					    return true;
				}
			}

		return false;
	}

}
