// TC: O(N + M) where N is length of String s and M is length of list word dictionary since we are storing string values in Set
// SC: O(N + M) storing dictionary in Set and for dp of n length

import java.util.*;
public class wordBreak {

	public boolean WordBreak(String s, List<String> wordDict) {
		
		  Set<String> set = new HashSet<>(wordDict);
	        boolean[] dp = new boolean[s.length()+1];
	        dp[0] = true;
	        
	        for(int i = 1; i <= s.length();i++){
	            for(int j = 0; j < i; j++){
	            	// check if the previous word was true(this we will know because we are updating our i value and j will be less than i, so J will also be updated
	            	// if the jth value in dp is true then we need check for further values in dp, Also we will check for substring in set which contains wordDictionary
	                if(dp[j] && set.contains(s.substring(j,i))){
	                	// if the word is present and previous words were also present, assign ith value in dp as true;
	                    dp[i] = true;
	                    // once we have found our value, we will move our substring ahead because we know that finding the other words in dictionary
	                    // will be available only when we move ahead in String s starting pointer.So, we break if find our solution
	                    break;
	                }
	            }
	        }
	     // return the last value in dp which will carry all the previous instances and current instance as true or false,
	      return dp[s.length()];
	}
	
	public static void main(String[] args) {
		
		wordBreak wb = new wordBreak();
		String s = "leetcode";
		List<String> wordDict = new ArrayList<>();
		wordDict.add("leet");
		wordDict.add("code");
		System.out.println(wordDict);
		System.out.println(wb.WordBreak(s, wordDict));
	}
}
