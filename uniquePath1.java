//TC: O(2^MN) 2 decisions for every cell
//SC: O(MN) recursive stack

//Brute force
class Solution {
    public int uniquePaths(int m, int n) {
        if(m == 0 && n == 0)
            return 0;
        
        return helper(0, 0, m, n);
    }
    
    private int helper(int i, int j, int m, int n){
        //base: we have reached an edge
        if(i == m || j == n)
            return 0;
        //we have reached destination cell
        if(i == m - 1 && j == n - 1)
            return 1;
        //logic: sum of down and right cells
        return helper(i+1, j, m, n) + helper(i, j+1, m, n);
    }
}