package Dec8;

class UniquePath {
    
    /*
    Time complexity: O(2^mn) because at every grid square, we have 2 options to take: go right and go down. Since total # of grid squares = mn, time complexity = 2^mn. 
    
    Approach: Brute force method.
    
    */
    
    public int uniquePaths(int m, int n) {
       return helper(0,0,m,n);
    }
    
    public int helper(int i, int j, int m ,int n) {
        // base
        if (i == m-1 && j == n-1) {
            return 1;
        }
         if (i >= m || j >= n) {
            return 0;
        }
        // logic
        return helper(i+1,j, m, n)+ helper(i,j+1,m,n);
        
    }
}