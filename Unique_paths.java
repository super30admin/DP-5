//Time Complexity : O(mn)
//Space Complexity : O(n)
//bottom up approach 
class Solution {
    public int uniquePaths(int m, int n) {
        //take dp array of size of row
        int [] dp = new int[n+1];
        //store last row last element as one
        dp[n-1] = 1;
        for(int i = m-1; i >= 0; i--){
            for(int j = n-1; j >= 0; j--){
                //bounds check
                if(i == m-1 && j == n-1) continue;
                //add rightside and lower row element 
                dp[j] = dp[j+1] + dp[j];
            }
        }
        //first element of array will be having the number of unique paths
        return dp[0];
    }
}