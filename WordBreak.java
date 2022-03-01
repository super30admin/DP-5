import java.util.HashSet;
import java.util.List;

// TC O(N^3)
// SC O(N)
public class WordBreak {

    public boolean wordBreak(String s, List<String> wordDict) {

        if (s == null || s.length() == 0) {
            return true;
        }
        boolean[] dp = new boolean[s.length() + 1];
        HashSet<String> dict = new HashSet<>(wordDict);
        dp[0] = true;

        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && dict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
