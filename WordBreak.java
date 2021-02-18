// Time Complexity : The time complexity is O(n^3) where n is the length of the string
// Space Complexity : The space complexity is O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {

        Set<String> set = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;

        for(int i=1;i<dp.length;i++){

            // Split the string at each index
            for(int j=0;j<i;j++){

                // split further only if the prefix is present
                if(dp[j] && set.contains(s.substring(j,i))){
                    dp[i] = true;
                }
            }
        }

        return dp[s.length()];

    }
}