//Word Break
/*TC: O(n^3)
SC: O(m+n)
 * Ran on LC: yes
 * Any problem faced on LC: no
 */
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        
        HashSet<String> set = new HashSet<>(wordDict);
        
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        for(int i =0;i<dp.length;i++){
            for(int j=0;j<i;j++){
                if(dp[j] && set.contains(s.substring(j,i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}


//Unique Paths
/*TC: O(m*n)
SC: O(m*n)
 * Ran on LC: yes
 * Any problem faced on LC: no
 */

 //Bottom Up Approach 
 class Solution {
    int[][] memo;
    public int uniquePaths(int m, int n) {
        
        if(m == 0 || n == 0)
            return 0;
        int [][] dp = new int[m+1][n+1];
        
        dp[m-1][n-1] = 1;
        for(int i=m-1;i>=0;i--)
        {
            for(int j=n-1; j>=0;j--)
            {
                if(i == m-1 && j == n-1) continue;
                dp[i][j] = dp[i+1][j] + dp[i][j+1];
            }
        }
        return dp[0][0];
    }
}


// Top Down Approach


class Solution {
    int[][] memo;
    public int uniquePaths(int m, int n) {
        
        if(m == 0 || n == 0)
            return 0;
        memo = new int[m][n];
        return dfs(0,0,m,n);
    }
    
    private int dfs(int i, int j, int m, int n)
    {
        //base case
        if(i == m-1 && j == n-1) return 1;
        if(i<0 || j<0 || i == m || j == n) return 0;
        
        //logic
        if(memo[i][j] == 0){
        memo[i][j] = dfs(i+1, j, m, n) + dfs(i, j+1, m, n);
        }
        
        return memo[i][j];
    }
}