// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes, 6ms
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

// This is a bottom up approach as we take the character of the string in an increasing order and check if entry in the dp table is true/false and assign the value in to the substring accordingly

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        
        Set<String> set = new HashSet<>(wordDict);
        
        boolean[] dp = new boolean[s.length() + 1];

        dp[0] = true;
        
        for(int i = 1; i <= s.length(); i++){
            for(int j = 0; j < i; j++){
                if(dp[j] && set.contains(s.substring(j,i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        
        return dp[s.length()];

    }
}
