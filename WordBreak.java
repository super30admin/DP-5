// Time Complexity : O(n^3)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
// Backtracking with memo
class Solution {
    
    // Backtracking with memo
    public boolean wordBreak(String s, List<String> wordDict) {
        return helper(s, new HashSet<>(wordDict), 0, new Boolean[s.length()]);
    }
    
    private boolean helper(String s, Set<String> set, int start, Boolean memo[]){       
        if(start == s.length()){
            return true;
        }
        
        if(memo[start]!= null){
            return memo[start];
        }
        
        for(int end=start+1; end<=s.length(); end++){
            if(set.contains(s.substring(start, end)) && helper(s, set, end, memo)){
                memo[start] = true;
                return memo[start];
            }
        }
        
        memo[start] = false;
        return memo[start];
   
    }
    



// Time Complexity : O(n^2)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
// DP
    public boolean wordBreakDP(String s, List<String> wordDict) {
        if(s==null || s.length()==0)
            return false;
        
        Set<String> set = new HashSet<>(wordDict);
        // ""
        // l
        // le
        // lee
        // leet
        
        boolean[] dp = new boolean[s.length()+1];
        dp[0]=true;
        
        for(int i=0; i<=s.length(); i++){
            for(int j=0; j<i; j++){
                if(dp[j] && set.contains(s.substring(j, i))){
                    dp[i] = true;
                    break;
                }              
            }
        }
        return dp[s.length()];
    }
}