// Time Complexity : O(MN)
// Space Complexity : O(MN) 
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
    public int uniquePaths(int m, int n) {
        int[][] matrix=new int[m][n];
       
        for(int i=0;i<m;i++){
            matrix[i][0]=1;
        }
        for(int j=0;j<n;j++){
           matrix[0][j]=1; 
        }
        
        for(int i=1;i<m;i++){
        for(int j=1;j<n;j++){
        matrix[i][j]= matrix[i-1][j]+matrix[i][j-1]; 
        } 
        }
        
        return matrix[m-1][n-1];
    }
}