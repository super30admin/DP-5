// Time Complexity: O(mn) 
// Space Complexity: O(n)
// DP optimized
public class UniquePaths
{
    public int uniquePaths(int m, int n) {
        if(m == 0)
            return 0;
        
        // we need only rows
        int dp[] = new int[n];
        // last row will always be 1
        Arrays.fill(dp, 1);
        
        for(int i = m-2 ; i >= 0 ; i--) // start second last row as we have evaluated last row
        {
            for(int j = n-2  ; j >= 0 ; j--) // we do not need last column as it will 1 and that value is in dp[n-1]
            {
                dp[j] = dp[j+1] + dp[j]; 
            }
        }
        
       return dp[0];
    }
}

// Time Complexity: O(mn) 
// Space Complexity: O(mn)
// DP array
public class UniquePaths
{
    public int uniquePaths(int m, int n) {
        if(m == 0)
            return 0;
        
        // extra row and col to avoid checking Out of bound conditions
        int dp[][] = new int[m+1][n+1];
        
        dp[m-1][n-1] = 1;
        for(int i = m-1 ; i >= 0 ; i--)
        {
            for(int j = n -1  ; j >= 0 ; j--)
            {
                if(i == m-1 && j == n -1) // to avoid m,n not be 0  
                    continue;
                dp[i][j] = dp[i][j+1] + dp[i+1][j]; 
            }
        }
        
       return dp[0][0];
    }

}


// Time Complexity: O(2^ mn) 
// Space Complexity: O(mn)
// Brute Force
public class UniquePaths
{
    
    public int uniquePaths(int m, int n) {
        if(m == 0)
            return 0;

       return dfs(m , n, 0, 0);
    }


    private int dfs(int m, int n, int r, int c)
    {
        // base
        if(r >= m || c >= n)
        {
            return 0;
        }
        if(r == m -1 || c == n -1)
        {
            return 1;
        }
        
        // logic
        // case bottom +  case right
        return dfs(m , n , r +1, c) +  dfs(m , n , r, c+1);
    }
}
