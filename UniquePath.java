//Time Complexity - O(2^m*n) where 2 is the number of choice and m*n beacuse need to traverse each cell in the matrix
//Space Complexity O(1)

class Solution {
    public int uniquePaths(int m, int n) {
      //edge case
      if(m == 0 && n == 0) {
        return 0;
      }
      return helper(0,0,m,n);
    }
  private int helper(int i, int j, int m, int n) {
    //base case
    if(i == m || j == n) return 0; //index out of bound
    if(i == m-1 && j== n-1) return 1; //reached finish line
    
    // logic
   //recursive move left and right
    return helper(i+1,j,m,n) + helper(i,j+1,m,n);
  }
}