// Time Complexity : O(n^3)
// Space Complexity : O(n+k) // string length + k HashSet
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        if(s == null || s.length()==0){
            return true;
        }
        HashSet<String> set = new HashSet<>(wordDict); 
        int n = s.length();
        boolean[] dp = new boolean[n+1];
        dp[0] = true;
        for(int i =1; i<n+1; i++){ //O(n)
            for(int j = 0; j<i;j++){ //O(n)
                if(dp[j] == true){
                    if(set.contains(s.substring(j,i))){ //O(n) for creating substring
                        dp[i] = true;
                        break;
                    }
                }
            }
        }
        return dp[n];
    }
}   