//1.word break
//Recursion
class Solution {
    Set<String> set;
    public boolean wordBreak(String s, List<String> wordDict) {
        if(s == null || s.length() == 0) return false;
        set = new HashSet<>(wordDict);
        return dfs(s,0);
        
    }

    private boolean dfs(String s,int idx){
        //base case
        if(idx == s.length()) return true;

        //logic
        //Using for loop based recursion
        for(int i = idx;i < s.length();i++){
            String sub = s.substring(idx, i+1);
            if(set.contains(sub) && dfs(s,i+1)){
                return true;
            }
        }
        return false;
    }
}

//Optimized Using DP
class Solution {
    //Using Bottom up
    //Bottom up because we are going from smaller sub problem to a bigger sub probelm
    Set<String> set;
    public boolean wordBreak(String s, List<String> wordDict) {
        if(s == null || s.length() == 0) return false;
        set = new HashSet<>(wordDict);
        int l = s.length();
        boolean[] dp = new boolean[l+1];
        dp[0] = true;
        for(int i = 1 ;i < dp.length;i++){
            for(int j = 0 ; j< i;j++){
                if(dp[j] && set.contains(s.substring(j, i))){
                       dp[i] = true;
                       break;
            }

        }
            

           
    }
    return dp[l+1-1];
}

    
}

//2nd Unique Paths
//Recursion
class Solution {
    //Using  1 d DP second try
    public int uniquePaths(int m, int n) {
        int[] dp = new int[n];
        dp[n-1] = 1;
        for(int j = n-2 ; j>=0;j--){
            dp[j] = dp[j] + dp[j+1];
        }
        return dp[0];
    }
}

//DP
//Time Complexity-> O(m*n)
//Space Complexity -> O(m)
class Solution {
    //Using  1 d DP second try
    public int uniquePaths(int m, int n) {
        int[] dp = new int[n];
        dp[n-1] = 1;
        for(int i = m-1 ; i>=0 ;i--){
           for(int j = n-2 ; j>=0;j--){
            dp[j] = dp[j] + dp[j+1];
           }
        }
        
        return dp[0];
    }
}

class Solution {
    //Using DP second try
    //Time Complexity-> O(m*n)
    //Space Complexity -> O(m*n)
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m+1][n+1];
        dp[m-1][n-1] = 1;
        for(int i = m-1 ; i>=0;i--){
            for(int j = n-1 ; j>=0;j--){
                if(i == m-1 && j == n-1) continue;
                dp[i][j] = dp[i+1][j] + dp[i][j+1];
            }
        }
        return dp[0][0];
    }
}