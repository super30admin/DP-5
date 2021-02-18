//Time Complexity: O((mn)^2) (Unsure)
//Space Complexity: O(mn) (Unsure)

//Successfully runs on leetcode: Time limit Exceeded

//Approach: We will start DFS from (0,0) index and move only in two directions - right and bottom as per the conditions
//till we reach the last index and the total paths will give us the required output.
class Solution {
    public int uniquePaths(int m, int n) {
        return helper(m, n, 0, 0);
    }
    
    private int helper(int m, int n, int i, int j)
    {
        //base
        if(i == m || j == n) return 0;
        if(i == m - 1 && j == n - 1) return 1;
        
        //logic
        return helper(m,n,i+1,j) + helper(m,n,i,j+1);
    }
}



//Time Complexity: O(mn) 
//Space Complexity: O(n)

//Successfully runs on leetcode: 0 ms

//Approach: As there are repeating subproblems, we can use DP approach and we start calculating the number of ways from last
//row and adding the bottom row and right column values to get the current value. The value at index 0 of the DP array will
//give the required output.


class Solution {
    public int uniquePaths(int m, int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        
        for(int i = m - 2; i >= 0; i--)
        {
            int result = 0;
            for(int j = n - 1; j >= 0; j--)
            {
                dp[j] += result;
                result = dp[j];
            }
        }
        return dp[0];
    }
}