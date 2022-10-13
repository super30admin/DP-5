class Solution {
    //tc = 2mn
    public int uniquePaths(int m, int n) {
        if(m==0 || n==0) return 0;
        return helper(0, 0, m , n);
    }
    private int helper(int i,int j, int m,int n)
    {
        //base case
        if(i == m-1 && j == n-1) return 1;
        if(i<0 || j<0 || i==m || j ==n) return 0;
        //logic
        //add right and bottom paths
        return helper(i,j+1,m,n) + helper(i+1,j,m,n);

    }
}