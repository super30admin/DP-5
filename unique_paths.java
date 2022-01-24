class Solution {
    public int uniquePaths(int m, int n) {
        if(m == 0) return 0; //if m is equal to 0, we simply return
        int[] dp = new int[n]; // we take an integer array wth name dp of length n
        Arrays.fill(dp, 1); // we initially fill the values in the array to 1
        for(int i = m - 2; i >= 0; i--) { //we iterate through the array starting from m - 2 and go bottom up
            for(int j = n - 2; j >= 0; j--) { //we iterate through the array starting from n - 2 and go botoom up
                dp[j] = dp[j + 1] + dp[j];  // we update the value at j to of the dp array by adding the right element to the old dp to get the new dp
            }
        }
        return dp[0]; // in the end, we return the dp[0]
    }
}
//tc and sc - O(m*n) and O(n)