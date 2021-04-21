class Solution {
    public int uniquePaths(int m, int n) {
      int[][] d = new int[m][n];
  
      //filling all the index values to 1
      for(int[] arr : d) {
        Arrays.fill(arr, 1);
      }

    //   iterating from 2nd row 2nd column
      for(int col = 1; col < m; ++col) {
        for(int row = 1; row < n; ++row) {
         // we reach a cell in 2 ways from top cell or left cell
         //so add values from both the cells
          d[col][row] = d[col - 1][row] + d[col][row - 1];
        }
      }
      //last cell in the matrix represents total unique paths
      return d[m - 1][n - 1];
    }
  }

  //Time Complexity: O(m*n)
  //Space Complexity: O(m*n)