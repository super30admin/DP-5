import java.util.HashSet;
import java.util.List;

public class WordBreak{
     //dp tabulation - o(l^3) 
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        int n = s.length();
        boolean dp[] = new boolean[n+1];
        dp[0] = true;
        for(int i = 1; i <= n;i++){
            for(int j = 0; j < i; j++){
                if(dp[j] && set.contains(s.substring(j,i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
    // HashSet<String> set;
    // HashMap<String, Boolean> memo;
    // //recursion based - 
    // public boolean wordBreak(String s, List<String> wordDict) {
    //     this.set = new HashSet<>(wordDict);
    //     this.memo = new HashMap<>();
    //     return helper(s,0);
    // }

    // //memoization based - o(l^3) 
    // public boolean helper(String s, int pivot){
    //     //base 
    //     if(pivot == s.length()) return true;
    //     String str = s.substring(pivot);
    //     if(memo.containsKey(str)){
    //         return memo.get(str);
    //     }
    //     //logic 
        
    //     for(int i = pivot; i < s.length(); i++){ //o(l) 
    //         String substr = s.substring(pivot, i+1); //o(l)
    //         if(set.contains(substr) && helper(s, i+1)){ //o(l) 
    //             memo.put(str, true);
    //             return true;
    //         }
    //     }
    //     memo.put(str, false);
    //     return false;
    // }

    // public boolean helper(String s, int pivot){
    //     //base 
    //     if(pivot == s.length()) return true;

    //     //logic 
    //     for(int i = pivot; i < s.length(); i++){
    //         String substr = s.substring(pivot, i+1);
    //         if(set.contains(substr) && helper(s, i+1)){
    //             return true;
    //         }
    //     }
    //     return false;
    // }
}