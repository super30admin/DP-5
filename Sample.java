// Time Complexity : O(2 ^ m*n) as 2 choices each time for each cell
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : No
// Any problem you faced while coding this : None

class Solution {
    public int uniquePaths(int m, int n) {
       return helper(0,0, m, n); 
    }
    
    public int helper(int i, int j, int m, int n)
    {
        //base
        if(i == m-1 && j == n-1) // when we reach the last index
            return 1;
        if(i>=m || j>=n) // if we go out of bounds
            return 0;
        
        //logic
        int right = helper(i+1,j,m,n); // call on right cell
        int left = helper(i,j+1,m,n); //call on left cell
        return right + left; // add the rows and columns to find the result for a recursion call
    }
}

// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

class Solution {
    public int uniquePaths(int m, int n) {
        int dp[][] = new int[m][n]; // dp array
        dp[m-1][n-1] = 1; // initialize the last cell to 1
        
        for(int i=m-1;i>=0;i--) // reverse loops
        {
            for(int j=n-1;j>=0;j--)
            {
                if(i+1 < m && j+1 < n) // check if the top and left value are in bounds
                dp[i][j] = dp[i+1][j] + dp[i][j+1]; // add the two
                else 
                dp[i][j] = 1; // else only one path possible
            }
        }
        
        return dp[0][0]; // return value at first cell
    }
}

// Time Complexity : O(n^2)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        //edge case
        if(s.length() == 0) 
            return true;
        HashSet<String> set = new HashSet<>(wordDict); // to store the dictionary
        boolean dp[] = new boolean[s.length()+1]; // dp array
        dp[0] = true; // set the first value to true as a null string prior to that is always valid
        
        for(int i=0;i<dp.length;i++) // iterate on dp array 
        {
            for(int j=0;j<i;j++) //move j till i
            {
                if(dp[j] && set.contains(s.substring(j,i))) // if  the string till j has been found and set contains the rest of string
                {
                    dp[i] = true; // set the value for the position as true i.e prior to that, we have found words in the dictionary
                }
            // if value not found j goes till i 
            }
        }
        
        return dp[dp.length-1]; // return value at last index
    }
}