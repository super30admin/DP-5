//Time complexity O(m*n)
//Space complexity O(m*n)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No
class Solution {
    int result;
    public int uniquePaths(int m, int n) {
        
       
        return helper(m,n,0,0);
               
               
        
        
    }
    private int helper(int m , int n , int i , int j){
        
        //base case
        if(i == m || j == n){
            
            return 0;
        }
        if(i == m-1 && j == n-1){
            
            return 1;
        }
        //logic
        
        return helper(m,n,i+1,j) + helper(m,n,i,j+1);
    }
}