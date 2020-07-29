//Time Complexity:O(nxm)
//Space Complexity:O(nxm)
class Solution {
  public int uniquePaths(int m, int n) {
    int[][] temp = new int[m][n];

    for(int[] arr : temp) {
      Arrays.fill(arr, 1);
    }
    for(int col = 1; col < m; ++col) {
      for(int row = 1; row < n; ++row) {
        temp[col][row] = temp[col - 1][row] + temp[col][row - 1];
      }
    }
    return temp[m - 1][n - 1];
  }
}
-------------------------------------------------------------------------------------