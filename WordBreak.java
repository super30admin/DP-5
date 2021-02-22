// Time Complexity : O(n^3)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        //edge
        if(s == null || s.length() == 0) return false;

        HashSet<String> set = new HashSet<>(wordDict);
        boolean [] dp = new boolean[s.length()+1];
        dp[0] = true;

        for(int i = 1; i < dp.length; i++){
            for(int j = 0; j < i; j++){
                //if current chosen substring valid and not in dp
                if(dp[j] && set.contains(s.substring(j,i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        //last index is of the whole string, if true then found all words in wordDict
        return dp[dp.length-1];
    }
}