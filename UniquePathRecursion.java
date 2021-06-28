package DP5;

/*

    -------------------------------------------------------------------------------------------------------
    Time complexity : o(n*k)
    space complexity: 
    Did this code run successfully in leetcode : yes
    problems faces : no*/

public class UniquePathRecursion {

    
    
    
    public int uniquePathsBruteForceRecursion(int m, int n) {

        return helper(m, n, 0, 0);
    }

    private int helper(int m, int n, int i, int j) {
        //base
        if (i == m || j == n)
            return 0;
        if (i == m - 1 && j == n - 1)
            return 1;

        //logic
        return helper(m, n, i, j + 1) + helper(m, n, i + 1, j);
    }
}
