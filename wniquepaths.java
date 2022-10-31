Time complexity: O(N×M).

Space complexity: O(N×M).
class Solution {
   
    int grid(int m,int n,Integer[][] a){
        if(a[m][n]!=null){
            return a[m][n];
        }
        if(m==0||n==0) {
        	a[m][n]=0;
        	return 0;
        }
        if(m==1||n==1) {
        	return 1;
        }
        a[m][n]=grid(m-1,n,a)+grid(m,n-1,a);
        return a[m][n];
    }
    public int uniquePaths(int m, int n) {
        Integer[][] a=new Integer[m+1][n+1];
        return grid(m,n,a);
    }
}
