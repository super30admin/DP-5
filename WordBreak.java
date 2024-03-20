package week9.day2;

import java.util.Arrays;
import java.util.List;

class Solution25 {
	public boolean wordBreak(String s, List<String> wordDict) {
		int Slen = s.length();

		boolean[] dp = new boolean[Slen + 1];
		dp[Slen] = true;
		for (int i = Slen - 1; i >= 0; i--) {
			for (String word : wordDict) {
				int word_length = word.length();
				if (i + word_length <= Slen) { 							// checking idx is within the bounds
					String sb = s.substring(i, i + word_length); 		// if in bounds, take sub string
					if (sb.equals(word)) { 								// if sub str from s, is same as word from wordDict
						if (dp[i + word_length] == true) { 				// if next idx is T =substr was found previously
							dp[i] = true; 								// set current idx to true
							break;
						}
					}
				}
			}
		}
		return dp[0];
	}
}

public class WordBreak {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution25 ob = new Solution25();
		String s = "leetcode";
		List<String> wordDict = Arrays.asList("lee", "code");
		System.out.println(ob.wordBreak(s, wordDict));
	}

}
