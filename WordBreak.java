//time complexity- O(N^2)
//space complexity- O(N)
import java.util.*;
public class WordBreak {
    static  boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for(int i = 1; i < n+1; i++){
            for(int j = 0; j < i; j++){
                if(dp[j] && set.contains(s.substring(j, i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
    public static void main(String[] args) {
        String  s = "applepenapple";
        List<String> wordDict = new ArrayList<>(Arrays.asList("apple", "pen"));
        System.out.println("Word can be made from dictionary? "+ wordBreak(s, wordDict));
    }
}
