// Time Complexity : O(n^2)
// Space Complexity :O(len(s))
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english
// have a boolean dp array to store the check, set innitial value true, then if we found the specific character through the dp array and if the substring is also found then set that dp[i] = true; and increase i pointer. at the end give the last value of DP array;
// Your code here along with comments explaining your approach
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> hs = new HashSet<>(wordDict);
        boolean [] dp = new boolean [s.length()+1];
        dp[0] = true;
        for(int i = 0; i < dp.length; i++){
            for( int j = 0; j < i; j++){
                if(dp[j] && hs.contains(s.substring(j,i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[dp.length-1];
    }
}