import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        // System.out.println(set);
        int l = s.length();
        boolean[] dp = new boolean[l + 1];
        dp[0] = true;

        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                // if(dp[j] && set.contains(s.substring(j,i))){
                if (dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                }
            }
        }
        return dp[l];
    }

    public static void main(String[] args) {
        WordBreak solution = new WordBreak();

        // Example input string and word dictionary
        String s = "leetcode";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("leet");
        wordDict.add("code");

        boolean isBreakable = solution.wordBreak(s, wordDict);
        System.out.println("Is the string breakable? " + isBreakable);
    }
}