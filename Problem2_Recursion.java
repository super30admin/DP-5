/**
LeetCode Submitted : No (Time Limit Error)
Time Complexity : 2^N
Space Complexity : O(1)

The idea is to recursively calculate all the possible paths till we reach end of the matrix.
So, we can find all the possible paths and take sum of it. Here, we are calculating the same subproblems again and again.

**/
class Solution {
    public int uniquePaths(int m, int n) {
        
        return findPaths(m,n,0,0);
        
    }
    
    private int findPaths(int m, int n, int i , int j){
        if(i == m-1 && j == n-1)
            return 1;
        
        if(i == m || j == n)
            return 0;
        
        for(int row = i;row<m;i++){
            for(int col = j; col<n;j++){
                return findPaths(m,n,row,col+1) + findPaths(m,n,row+1,col);
            }
        }
         
        return 0;
    }
}
