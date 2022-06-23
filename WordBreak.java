// Time Complexity : O(l^3):-> O(l^2) for traversal and O(l) for subString(), l = string length
// Space Complexity : O(l)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
public class WordBreak {
    class Solution {
        public boolean wordBreak(String s, List<String> wordDict) {
            Set<String> set = new HashSet<>(wordDict);
            boolean[] dp = new boolean[s.length()+1];
            dp[0] = true;

            for(int i=1; i< dp.length; i++) {
                for(int j=0; j<i; j++) {
                    if(dp[j] && set.contains(s.substring(j,i))) {
                        dp[i] = true;
                        break;
                    }
                }
            }

            return dp[s.length()];
        }

    }
}
