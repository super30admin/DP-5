// Time Complexity :O(m*n*t) Where n is the length of the string ,m is the number of words in wordict, t is the maximum length of any word in wordict
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : nothing

import java.util.List;

public class WordsBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp= new boolean[s.length()+1];
        dp[s.length()]=true;

        for(int i=s.length()-1; i>=0; i--){
            for(String w:wordDict){
                if(i+w.length() <= s.length() && s.substring(i,i+w.length()).equals(w)){
                    dp[i]=dp[i+w.length()];
                }
                if(dp[i]){
                    break;
                }
            }
        }
        return dp[0];
    }
}
