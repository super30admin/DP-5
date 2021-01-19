// Time Complexity : O(n*m) 
// Space Complexity :O(n*,m) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :  No


// Your code here along with comments explaining your approach: Create a new array and traverse through it by updating the number of ways to
// reach that position by adding the top and left element. Return the last element of the array.
class Solution {
    public int uniquePaths(int m, int n) {
        int[][] t = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++)
            if(i==0||j==0){
                t[i][j]=1;                
            }
            else{
                t[i][j]=t[i-1][j]+t[i][j-1];
            }
        }
        return t[n-1][m-1];
    }
}