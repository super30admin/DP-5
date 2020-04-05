# Time complexity:O(m*n)
# Space complexity: 0(1)
# Did code run successfully on leetcode: yes
# Any problem you faced: No






class Solution {
    public int uniquePaths(int m, int n) {

        int[][] distinctWays = new int[m][n];

        for(int j = 0; j < n; j++){
           distinctWays[0][j] = 1;
        }

         for(int i = 0; i < m; i++){
           distinctWays[i][0] = 1;
        }



        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                distinctWays[i][j] = distinctWays[i - 1][j] + distinctWays[i][j - 1];
            }
        }


        return distinctWays[m-1][n-1];
    }
}