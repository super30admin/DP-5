/*
Desc : We take a bracket of size n ,ie the smaller size of the two sides of matrix given, and we fill 1s for use in coming iterations
we iterate through the matrix and add the right element of the dp to current one and previous element to obtain the current total paths.
eventually when we converge to first eleemtn we would find the total unique paths that lead to the exit.
Time Complexity : O(n2)
Space Complexity : O(n) where n is the smaller side among the sides of matrix.
*/

class Solution {
    public int uniquePaths(int m, int n) {
        if(m<n) return uniquePaths(n,m);
        int dp[] = new int[n];
        Arrays.fill(dp,1);
        for(int i = m-2; i>=0; i--){
            int right = 0;
            for(int j = n-1; j >= 0;j--){
                dp[j] = dp[j] + right;
                right = dp[j];
            }
        }
        return dp[0];
    }
}
