//approach- Dynamic Programming
/*
1. we will start calculating sum from the destination itself
2. and traverse upward, with holding a running sum from neighbors (right and bottom). 
TC -O(m*n), sc - O(1)
*/
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        
        //initial position or destination has obstacle.
        if(obstacleGrid[m-1][n-1] == 1 || obstacleGrid[0][0] == 1 ) return 0;
        
        obstacleGrid[m-1][n-1] = -1; // tart wit -1 as 1 represents obstacle. 
        
        for(int i= m-1 ; i>=0; i--)
        {
            for(int j = n-1; j>= 0; j--)
            {
                //if grid has 1 then it's obstacle and just continue. last position/destination is invoked through loop so dont do anything. as we already put -1.
                if((obstacleGrid[i][j] == 1) || (i == m-1 && j == n-1)) continue;
                if(j!= n-1 && i!= m-1) //we are not at boundaries
                {
                    if(obstacleGrid[i][j+1] == 1 && obstacleGrid[i+1][j] == 1) //both neighbor has obstacles
                    {
                      obstacleGrid[i][j] =0;  
                    }
                    else if(obstacleGrid[i][j+1] == 1) //only col neighbor has obstacles
                    {
                      obstacleGrid[i][j] = obstacleGrid[i+1][j];  
                    }
                    else if(obstacleGrid[i+1][j] == 1) //only row neighbor has obstacle
                    {
                        obstacleGrid[i][j] = obstacleGrid[i][j+1];
                    }
                    else //no obstacles
                    {
                        obstacleGrid[i][j] = obstacleGrid[i+1][j] + obstacleGrid[i][j+1];  
                    }
                }
                if(j == n-1) //we are at column boundary
                {
                    obstacleGrid[i][j] = obstacleGrid[i+1][j] == 1 ? 0 : obstacleGrid[i+1][j];
                }
                if(i == m-1) //we are at row boundary
                {
                    obstacleGrid[i][j] = obstacleGrid[i][j+1] == 1 ? 0 : obstacleGrid[i][j+1];
                }
            }
        }
        return -obstacleGrid[0][0]; // we started with -1, so last answer should be mutated to -(-num) = +num
        
    }
}