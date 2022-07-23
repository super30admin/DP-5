//Time: O(m*n)
//Space:O(m*n)

//DP Solution
class Solution {
    public int uniquePaths(int m, int n) {
        //here we create a matrix with one extra row and column
        int [][] dp = new int [m+1][n+1];
        
        //making the last element of the matrix '1', as from that point onwards there is only one way out(to the right)
        //good to note that here we are considering [m-1][n-1] element as the last elem because
        //the extra row and column will only contain '0's and they will help us find the no ways possible for 
        //all rows and columns without any extra code, especially for the last row [m-1] and last column [n-1]
        dp[m-1][n-1] = 1;
        
        for(int i = m-1; i >= 0; i--) {
            for(int j = n-1; j >= 0; j--) {
                
                //this is because we do not want to check the right and bottom directions of the last element
                if(i == m-1 && j == n-1) continue;
                
                //finding the number of paths possible on the right and bottom cell of the matrix and adding the sum to the current cell
                dp[i][j] = dp[i][j+1] + dp[i+1][j];      
            }
        }
        //returning the first element which will be storing the maximum possible no. of ways as we are usign a bottom up approach
        return dp[0][0];
    }
}