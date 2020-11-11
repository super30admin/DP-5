// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes, 1ms
// Any problem you faced while coding this :


// Since this is top-down approach and we can move only in down or right, we need to check the values in
// left or upper cells and add those we get to the value in the final cell 

class Solution {
    public int uniquePaths(int m, int n) {
        
        int[][] arr = new int[n][m];
        
        Arrays.stream(arr).forEach(a -> Arrays.fill(a,1));

        for(int i = 1; i < n;i++){
            for(int j = 1; j < m; j++){
                arr[i][j] = arr[i-1][j] + arr[i][j-1];
            }
        }
        
        return arr[n-1][m-1];
    }
}