import java.util.*;
/*************************************************Brute Force****************************************/
//Time Complexity : O(n^n), n choices for each string
//Space Complexity : O(n), 	recursive stack
//Did this code successfully run on Leetcode : yes
//Any problem you faced while coding this : none

class Word_Break_Brute_Force {
	Set<String> set;
	public boolean wordBreak(String s, List<String> wordDict) {
		set = new HashSet<>(wordDict);
		return helper(s);
	}
	private boolean helper(String s){
		if(s.length() == 0)
			return true;

		for(int i=0; i<=s.length(); i++){
			if(set.contains(s.substring(0,i)) && helper(s.substring(i))){
				return true;
			}
		}
		return false;
	}
}

/*************************************************Dynamic Programming****************************************/
//Time Complexity : O(n^3)
//Space Complexity : O(n)
//Did this code successfully run on Leetcode : yes
//Any problem you faced while coding this : none

/**Using Dynamic programming, create a dp matrix
 * For each index , we check all the words created from a valid partition location to curr index
 * if it exists in the dictionary, put 1, else leave it as 0 false* ***/

class Word_Break_DP {
	public boolean wordBreak(String s, List<String> wordDict) {
		if(s.length() == 0)
			return true;

		Set<String> set = new HashSet<>(wordDict);
		boolean[] dp = new boolean[s.length() + 1]; //dp array
		dp[0] = true;    // set the first value to true 

		for(int i=0; i<dp.length; i++){	// O(n^2)
			for(int j=0; j<i; j++){
				if(dp[j] && set.contains(s.substring(j,i))){	// O(n)
					dp[i] = true;   // set the value for the position as true i.e prior to that, we have found words in the dictionary
				}
			}
		}
		return dp[dp.length-1];
	}
}