/*

Thought Process:
    There are repeated permutations on how to use the string. So it's a dp problem.
    Understanding on how to create a dp boolean array lies the basis of the solution in here.
    
    T.C -> O(N3) - 2 nested loops and substring
    S.C -> O(N) - where N is the length of the string

*/
import java.util.*;
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        
        Set<String> wordDictSet = new HashSet<>(wordDict);
        
        for(int i=1; i<=s.length(); i++){
            for(int j=0; j<i; j++){
                
                // Mistakes Commited -> Was not checking dp[j] == true
                if(dp[j] && wordDictSet.contains(s.substring(j,i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}