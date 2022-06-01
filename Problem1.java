import java.util.HashSet;
import java.util.List;

public class Problem1 {
    // Brut Force solution
    // TC : O(2^n)
    // SC : O(n)
    public boolean wordBreak(String s, List<String> wordDict) {
        if (wordDict == null || wordDict.size() == 0) return false;
        HashSet<String> set = new HashSet<>(wordDict);
        return helper(s, set);
    }

    private boolean helper(String s, HashSet<String> set) {
        //base
        if (s.length() == 0) return true;

        //logic
        for (int i = 0; i < s.length(); i++) {
            String sub = s.substring(0, i + 1);
            if (set.contains(sub) && helper(s.substring(i + 1), set)) {
                return true;
            }
        }
        return false;
    }

    // DP solution
    // TC : O(m*n^3)
    // SC : O(m + n)
    public boolean wordBreak1(String s, List<String> wordDict) {
        if (wordDict == null || wordDict.size() == 0) return false;

        HashSet<String> set = new HashSet<>(wordDict);

        int n = s.length();

        boolean[] dp = new boolean[n + 1];
        dp[0] = true;

        for (int i= 1; i <=n; i ++){
            for (int j = 0; j <i ; j ++){
                if (dp[j]){
                    String sub = s.substring(j, i);
                    if (set.contains(sub)){
                        dp[i] = true;
                        break;
                    }
                }
            }
        }
        return dp[s.length()];

    }

}
