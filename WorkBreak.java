//Time Complexity : O(N^3)

//Space Complexity : O(N)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

public class WordBreak {

	public boolean wordBreak(String word, List<String> wordDict) {
		HashSet<String> set = new HashSet<>(wordDict);
		boolean dp[] = new boolean[word.length() + 1];
		dp[0] = true;
		for (int i = 1; i < dp.length; i++) {
			for (int j = 0; j < i; j++) {
				if (dp[j] && set.contains(word.subSequence(j, i))) {
					dp[i] = true;
					break;
				}
			}
		}
		return dp[dp.length - 1];
	}

	public static void main(String args[]) {
		WordBreak wordBreak = new WordBreak();

		String word = "leetcode";
		List<String> wordDict = Arrays.asList("leet", "code");

		System.out.print(wordBreak.wordBreak(word, wordDict));

	}
}
