//approach -1
/*
    we can go only bottm and right. 
    recursive /exhausted approach
    1. helper method call tat return the sum. 
    2. helper method holds position of robot, let say r, c ; which is row and col
    3. we call the helper method to go right, which is c+1
    4. we call the helper method to go down  which is r+1
    at last we return the sum of both of them 
    
    //base case is - if we reach ut of bound, we dont find path, return 0
    //we reach to the m-1 and n-1, means that's the corrct path and we return 1
    TC - recursive - Exponential
    sc - O(1)
*/

class Solution {
    int m, n;
    public int uniquePaths(int m, int n) {
        if(m ==0 || n == 0) return 0;
        
        this.m =m;
        this.n = n;
        
        return helper(0,0);
    }
    
    private int helper(int row, int col)
    {
        //base case
        if( row == m || col ==n) return 0;
        if(row == m-1 || col == n-1) return 1;
        
        //logic
        int rightPath = helper(row, col+1);
        int bottomPath = helper(row+1, col);
        
        return rightPath + bottomPath;
    }
}