# DP-5

## Problem1: (https://leetcode.com/problems/word-break/)
//Time Complexity = O(m*n)
//Space Complexity = O(m*n)
//DP Solution
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        if(s == null || s.length() == 0)return false; 
        
        HashSet<String> set = new HashSet<>(wordDict);
        int n = s.length(); 
        boolean[] dp = new boolean[n+1]; 
        dp[0] = true; 
        
        for(int i = 1; i < dp.length; i++){
            for(int j = 0; j < i; j++){
                if(dp[j] && set.contains(s.substring(j,i))){
                    dp[i] = true;
                    break; 
                }
            }
        }
        return dp[dp.length - 1];
    }
}

//Time Complexity = n^n
//Space Complexity = O(n)
//Recursive Solution
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        if(s == null || s.length() == 0)return false; 
        
        HashSet<String> set = new HashSet<>(wordDict); 
        return helper(s, set); 
    }
    
    private boolean helper(String s, HashSet<String> set){
        //base
        if(s.length() == 0) return true; 
        //logic
        for(int i = 1; i <= s.length(); i++){
            if(set.contains(s.substring(0,i)) && helper(s.substring(i),set)){
                return true;
            }
        }
        return false;
    }
}

## Problem2: (https://leetcode.com/problems/unique-paths/)
//Time Complexity = O(m*n)
//Space Complexity = O(m*n)
class Solution {
    public int uniquePaths(int m, int n) {
       
        int[][] dp = new int[m][n];
        
        
        for(int i = 0; i < dp.length; i++)
        {
            dp[i][0] = 1; 
        }
        
        for(int j = 0; j < dp[0].length; j++)
        {
            dp[0][j] = 1;
        }
        
        for(int i = 1; i < dp.length; i++){
            
            for(int j = 1; j < dp[0].length; j++){
                
                dp[i][j] = dp[i-1][j] + dp[i][j-1]; 
                
            }
        }
        
        return dp[m-1][n-1]; 
    }
}