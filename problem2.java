// Time Complexity : O(n*m) m is number of rows and n is number of columns
// Space Complexity : O(n) for rows
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Approach : I am using a DP approach because of repeated subproblem and exhaustive search problem - for the first row there is only one way to reach each index - go right, so all are filled with 1. For first column, only one way - to go down. Now for each index, the total number of ways to reach there depends on 2 points - the point above (we can come down) and the point to its left (we can go right), so we just add the total ways we can come to these points. Each index represents the number of ways we can come to that point - we can use 2D array for comprehensive answer but we only care about the last point, so we can optimize by only keeping the last row and making new one based off of it. 

class Solution {
    public int uniquePaths(int m, int n) {
        int[] prevRow = new int[n];
        Arrays.fill(prevRow,1);
        for(int i = 1; i<m; i++){
            int [] newRow = new int[n];
            newRow[0]=1;
            for(int j = 1; j<n; j++){
                newRow[j]=newRow[j-1]+prevRow[j];
            }
            prevRow = newRow;
        }
        return prevRow[n-1];
    }
}