// Time Complexity : O(M*N)
// Space Complexity : O(M*N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class Solution {
    public int uniquePaths(int m, int n) {
        
        int[][] distinctWays = new int[m][n];
        
        // Recurrence Relation
        //Base case
        for(int i=0;i<m;i++)
            distinctWays[i][0]=1;
        
        for(int j=0;j<n;j++)
            distinctWays[0][j]=1;
        
        //otherwise
        for(int i=1;i<m;i++) {
            for(int j=1;j<n;j++) {
                distinctWays[i][j]=distinctWays[i-1][j]+distinctWays[i][j-1];
            }
        }
        return distinctWays[m-1][n-1];
    }
}
