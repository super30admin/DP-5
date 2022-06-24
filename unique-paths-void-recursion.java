class Solution {
    // Bruteforce solution
    // Time complexity is O(2^mn)
    // Space complexity is O(mn)
    // This solution gives time limit exceed
    int result;
    public int uniquePaths(int m, int n) {
        // Edge case
        if(m == 0 || n ==0 ) return 0;
        result = 0;
        helper(0,0,m,n);
        return result;
    }
    
    private void helper(int i, int j, int m, int n){
        // base case
        if(i == m-1 && j == n-1){
            result= result+1;
            return;
        }
        if(i == m || j == n) return;
        
        // logic
        helper(i+1, j, m, n);
        
        helper(i,j+1, m,n);
        
    }
}