import java.util.HashSet;
import java.util.List;

/***
 Using DP
 TC - O(n^3)
 SC - O(n + k) {dp + hashmap}
 */

class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        if(s == null || s.length() == 0)
            return true;

        int n = s.length();
        boolean[] dp = new boolean[n+1];
        dp[0] =true; //empty string is always present in dict

        HashSet<String> set = new HashSet<>(wordDict);

        for(int i =1; i <=n; i++) {
            for(int j =0; j < i; j++) {
                if(dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] =true;
                    break;
                }
            }
        }


        return dp[n];
    }
}