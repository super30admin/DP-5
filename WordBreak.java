// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

public class WordBreak {
    class Solution {
        public boolean wordBreak(String s, List<String> wordDict) {
            Set<String> set = new HashSet<>(wordDict);
            int sLen = s.length();
            boolean dp[] = new boolean[sLen + 1];
            dp[0] = true;

            for(int i = 1; i <= sLen; i++){
                for(int j = 0; j < i; j++){
                    if(dp[j] && set.contains(s.substring(j, i))){
                        dp[i] = true;
                        break;
                    }
                }
            }
            return dp[sLen];
        }
    }
}
