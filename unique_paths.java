// Time Complexity : O(m*n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english: Used memoization, to store the last sum, this will help overcome the time limit exceeded error while using recussion

// Your code here along with comments explaining your approach




class Solution {
    int [][]  memo;
    public int uniquePaths(int m, int n) {
        memo = new int [m][n];
        return helper(0,0,m,n);
    }
    
    private int helper(int i, int j, int m, int n){
        // base case
        if(i==m-1 && j==n-1) return 1;
        
        // logic
        
        int case1 = 0;
        if(i < m-1){
            if(memo[i+1][j] == 0){
                memo[i+1][j] = helper(i+1,j,m,n);
            }
            case1 = memo[i+1][j];
        }
        
        int case2 = 0;
        if(j < n-1){
            if(memo[i][j+1]==0){
                memo[i][j+1] = helper(i,j+1,m,n);
            }
            case2 = memo[i][j+1];
        }
        return case1+case2;
    }
}