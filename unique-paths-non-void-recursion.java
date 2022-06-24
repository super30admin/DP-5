class Solution {
    // Non Void Recursion bruteforce solution
    // Time complexity is O(2^mn)
    // Space complexity is O(mn)
    // This solution give Time Limit Exceed
    public int uniquePaths(int m, int n) {
        // Edge case
        if(m == 0 || n ==0 ) return 0;
        return helper(0,0,m,n);
    }
    
    private int helper(int i, int j, int m, int n){
        // base case
        if(i == m-1 && j == n-1){
            return 1;
        }
        if(i == m || j == n) return 0;
        // logic
        int right = helper(i+1,j, m,n);
        int buttom = helper(i,j+1, m,n);
        return right + buttom;
        
    }
}