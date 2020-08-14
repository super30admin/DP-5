//let m and n be the rows and columns of the matrix
//time complexity O(2^(mn))
//space complexity O(1)

class Solution {
    public int uniquePaths(int m, int n) {
        return helper(0, 0, m, n);
    }
    private int helper(int i, int j, int m, int n){
        //base
        if(i > m - 1 || j > n -1) return 0;
        if(i == m - 1 && j == n - 1) return 1;

        //logic
        //System.out.println("right" + i + "," + (j+1));
        int right = helper(i, j + 1, m, n);
        //System.out.println("bottom" +  (i + 1) + "," + j);
        int bottom = helper(i+1, j, m, n);
        return right + bottom;
    }
}
