//Time Complexity: O(2^(m*n))
//Space Complexity: O(m+n)
//Code run successfully on LeetCode.

public class Problem2_1 {
    int m, n;
    
    public int uniquePaths(int m, int n)
    {
       this.m = m;
       this.n = n;
       
       return helper(0,0);
   }
   
   private int helper(int i, int j)
   {
       if(i == m-1 && j == n-1)
           return 1;
       
       else if(i >= m || i <0|| j >= n|| j <0)
           return 0;
       
       return helper(i,j+1) + helper(i+1, j);
   }
}
