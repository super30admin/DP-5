// Time Complexity :O(mn)
// Space Complexity :O(m) or O(n) whichever is smaller
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
class Solution {
    public int uniquePaths(int m, int n) {
        //If m is greater than interchange m and n
        if(m>n) return uniquePaths(n,m);
        int[] dp = new int[m];

        //Go through every cell and find out how many paths can it have by adding down cell and right cell
        for(int j=n-1; j>=0;j--){
            for(int i=m-1; i>=0; i--){
                int down = 0;
                int right = 0;
                if(i == m-1 && j == n-1) dp[i] = 1;
                else{
                    if(i != m-1) down = dp[i+1];
                    if(j != n-1) right = dp[i];
                    dp[i] = down + right;
                }
            }
        }

        return dp[0];  
    }
}