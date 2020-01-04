/*

https://leetcode.com/problems/unique-paths/
Did it run on leet code: yes
Did you face any problem: No

Time Complexity: 0(N2)
Space Complexity: 0(N2)

Algorithm:
- at every (i,j) in the matrix you can either arrive from (i-1,) or (i,j-1) which becomes our recusrive relation
- our dp[i][j] denotes number ways to rech (i,j)
- recursive relation dp[i][j] = dp[i-1][j] + dp[i][j-1]


*/


class Solution {
    public int uniquePaths(int m, int n) {
        
        int[][] grid = new int[m+1][n+1];
        
        for(int i=0;i<=m;++i){
            grid[i][0]=1;
        }
        
        for(int j=0;j<=n;++j){
            grid[0][j]=1;
        }
        
        
        for(int i=1;i<=m;++i){
            for(int j=1;j<=n;++j){
                grid[i][j]=grid[i-1][j]+grid[i][j-1];
            }
        }
        
        return grid[m-1][n-1];
    }
}