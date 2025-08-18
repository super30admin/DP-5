// Time Complexity : O(n * n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// Approach : At each index of string, check if it is ending of a word in dictionary and if remainder string
/// can also be added to broken into words in dict i.e, dp is true, then set dp[i]= true else false
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean dp[] = new boolean[s.length()+1];
        int  n = s.length();
        dp[0] = true;
        for(int i=1;i<n+1;i++){
            for(int j=0;j<i;j++){
                if(dp[j] && wordDict.contains(s.substring(j, i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
}