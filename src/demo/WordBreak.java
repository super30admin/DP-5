package demo;

import java.util.HashSet;
import java.util.List;

//Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words.
//The same word in the dictionary may be reused multiple times in the segmentation.
//You may assume the dictionary does not contain duplicate words.
//Example 1:
//Input: s = "leetcode", wordDict = ["leet", "code"]
//Output: true
//Explanation: Return true because "leetcode" can be segmented as "leet code".


//	Time:  O(n^2) 
//	Space O(n)
//	LeetCode: yes
public class WordBreak {
	public boolean wordBreak(String s, List<String> wordDict) {
		//initializing set with wordDict list
		HashSet<String> set  = new HashSet<>(wordDict);
		if(s.length()==0) return true;

		boolean[] dp = new boolean[s.length()+1];
		dp[0] = true;

		for(int i=1 ; i < dp.length;i++) {
			for(int j=0; j < i ; j++) {
				//iterating over string s, if a word in set is matched
				//then make dp true else false
				if(dp[j] == true && set.contains(s.substring(j,i))) {
					dp[i] = true;
				}
			}
		}
		return dp[dp.length-1];

	}
}
