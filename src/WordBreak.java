import java.util.HashSet;
import java.util.List;

public class WordBreak {
		// Time Complexity : O(n^n) where n is the length of the string
		// Space Complexity : O(n)
		// Did this code successfully run on Leetcode : yes
		// Any problem you faced while coding this : No
		// Your code here along with comments explaining your approach
		/*
		 * This is a brute force approach.
		 */
		HashSet<String> set;
	    public boolean wordBreak1(String s, List<String> wordDict) {
	        if(s == null || s.length() == 0) return false;
	        set = new HashSet<>(wordDict);
	        return helper1(s);
	    }
	    
	    private boolean helper1(String s){
	        //base
	        if(s.length() == 0) return true;
	        //logic
	        for(int i = 0; i < s.length(); i++){
	            if(set.contains(s.substring(0, i+1)) && helper1(s.substring(i+1))){
	                return true;
	            }
	        }
	        return false;
	    }
	    
	    // Time Complexity : O(n^3) where n is the length of the string
	 	// Space Complexity : O(n)
	 	// Did this code successfully run on Leetcode : yes
	 	// Any problem you faced while coding this : No
	 	// Your code here along with comments explaining your approach
	 	/*
	 	 * This is a DP approach where the a boolean array of length equal to string's length + 1 is maintained;
	 	 * Initially, the 1st index of the boolean array will be set to true, where it depicts that the previous index of the given string, 
	 	 * i.e., and empty string is a valid string present in the wordDict or not.
	 	 * Next the ith index will be starting it's traversal from the string index 1 and the jth index will be pointing at 0th index of the string.
	 	 * at every point where dp[j] is marked as true(which means the string between i and j is present in the set) further processing of the 
	 	 * remaining string until i is reached will not be performed as valid splits may not occur.
	 	 * the last index of the boolean array depicts where the string can be segmented properly or not.
	 	 */
	    
	    public boolean wordBreak(String s, List<String> wordDict) {
	        if(s == null || s.length() == 0) return false;
	        HashSet<String> set = new HashSet<>(wordDict);
	        boolean [] dp = new boolean [s.length() + 1];
	        dp[0] = true;
	        for(int i = 1; i < dp.length; i++){
	            for(int j = 0; j < i; j++){
	                if(dp[j] && set.contains(s.substring(j,i))){
	                    dp[i] = true;
	                    break;
	                }
	            }
	        }
	        return dp[dp.length-1];
	    }
}
