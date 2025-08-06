// Problem1: (https://leetcode.com/problems/word-break/)

// Time Complexity : O(n^2)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
//we use a dp array which says if previous substring to current char is valid or not.
// we check for the entire owrd, if not then check from j=0 if that is valid then check if
// substring from j to i, makes a valid word. thus we check all possible ways of partition


class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        int n = s.length();
        boolean dp[] = new boolean[n+1];
        dp[0] =  true;
        for(int i=1;i<=n;i++){
            for(int j=0;j<i;j++){
                if(dp[j]&&set.contains(s.substring(j,i))){
                    dp[i]=true;
                    break;
                }
            }
        }
        return dp[n];
    }
}