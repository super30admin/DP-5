****//111.62.UNIQUE PATHS- Basic approach*****
  //Time complexity:o(m square *n square);
  //Space complexity:0(m*n)
class Solution {
    public int uniquePaths(int m, int n) {
        return helper(0,0,m,n);
        
    }
    
    private int helper(int i, int j, int m, int n)
    {
        //Base
        
        
        //If goes out of bounds
        if(i==m || j==n)
        {
            return 0;
        }
        
        //Hits the end
        if(i==m-1 && j==n-1)
        {
            return 1;
        }
        
        
        //Logic
        return helper(i+1, j, m, n) + helper(i,j+1,m,n);
    }
}

****//111.62.UNIQUE PATHS- Basic approach*****
//Time complexity:o(m*n);
//Space complexity:0(m*n)


class Solution {
    public int uniquePaths(int m, int n) {
        //We need one grid for maintaining the values
        
        //I am taking one extra row and col to handle the case of 
        int[][] grid=new int[m+1][n+1];
        
        //So for the corner-last index make sure it is assigned 1
        grid[m-1][n-1]=1;
        
        //Iterating matrix in the reverse order
        for(int i=m-1;i>=0;i--)
        {
            for(int j=n-1;j>=0;j--)
            {
                if(i==m-1 && j==n-1) continue;
                grid[i][j] =grid[i+1][j]+grid[i][j+1];
            }
        }
        
        return grid[0][0];
        
        
        
    }
}
