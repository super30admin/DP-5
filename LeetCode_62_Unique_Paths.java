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


//DP approach
/*
1. we will take a matrix of siex m+1, n+1
2. by default all the fields intialized to 0 in java
3. we amke sure to update the m-1, n-1 position as 1 as that's th destination we want to reach to. 
4. at one, we start running a for loop backward, from m-1 to m and n-1 to n
while ding this, partciualr cell will hold the sum == right cell + bottom cell
so, for any cell x, it's value  = right side + bottom side cell/ 
and this way we will keep filling our all the cells until we reach the first cell. 
5. at last our answer will lie in m=0 and n=0
TC - O(m*n) - raversing through and building matrix. 
sc - O(m*n)
*/

class Solution {
    public int uniquePaths(int m, int n) {
        if(m ==0|| n==0) return 0;
        
        //for ur dp matrix
        m = m+1; 
        n = n+1;
        
        int[][] dp = new int[m][n];
        dp[m-2][n-2] = 1;
        
        for(int i = m-2; i>=0; i--)
        {
            for(int j = n-2; j>=0; j--)
            {
                if(i == m-2 && j == n-2) continue; // otherwise loop will update this value as well 
                dp[i][j] =  dp[i][j+1] + dp[i+1][j];
            }
        }
        return dp[0][0];
    }
}