// Time Complexity : O(n^2), n is string length
// Space Complexity : O(n + m), n is string length (dp array), m is wordDict size (HashSet)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :



//DP 
//TC : O(n^2), n is string length
//SC : O(n + m), n is string length (dp array), m is wordDict size (HashSet)
//we will find the word from len j to i in dic, if dp[j] is true
//dp[0] is set true, as j is considered to be empty string at start, so we set to true
//we check at each index of j thats true, we check if substring of j-i (inclusive) is present in wordDict
//if yes, we make dp[i] to true
//if word can be split using worddcit, last index will be true
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        //create a new dp array of length + 1
        boolean[] dp = new boolean[n+1];
        dp[0] = true;
        // set for O(1) look up
        HashSet<String> set = new HashSet<>(wordDict);
        //for each char (0 - n) of string
        for(int i = 0; i < n; i++) {
            //for each char j - i (inclusive) j<=i (to check last char separately)
            for(int j = 0; j <= i; j++) {
                //if index j is true, then find if j-i is present in worddict
                //(j, i+1) as substring includes (j-i) only
                if(dp[j] && set.contains(s.substring(j,i+1))) {
                    //make i+1 true (i starts from 0, for string, and dp[0] is already set to true, so dp starts i+1)
                    dp[i+1] = true;
                    //end the loop, we need only one word break thats possible
                    break;
                }
            }
        }
        //to check if word break is possible
        //last index of dp array should be true, so return the last index value (true/false)
        return dp[dp.length-1];     
    }
}
