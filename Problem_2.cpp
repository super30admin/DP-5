/**
 * @Time Complexity:
 * DP: O(m*n)  where m is number of rows and n is number of columns
 * DFS: O(m*n)  where m is number of rows and n is number of columns
 */

/**
 * @Space Complexity:
 * DP: O(n)  where n is number of columns
 * DFS: O(m*n)  where m is number of rows and n is number of columns
 * 
 */

/**
 * @Approach:
 * First we start with the exhaustive approach and there
 * we observe repeated subproblems. So, we try for 
 * DP solution.
 * 
 * We start with bottom up approach. To reach the
 * end from the top we were moving in either right
 * or down direction. So when we start from the end,
 * we obeserve that for particular cell
 * the number of ways is the sum of the value of the cell
 * in the same column and next row and value of the cell
 * in the next column and same row. Based on this 
 * we build our solution and the start cell will give us the result.
 * 
 * DFS solution:
 * Fo every cell we have two option, either move right or down.
 * SO, we can think of it as a tree. And the sum of all
 * the nodes at each level will give us the number of ways for that
 * level or cell.  Based on this we use dfs approach. 
 * 
 */

//The code ran perfectly on leetcode

//DP Solution
class Solution {
    vector<vector<int>> memo;
public:
    int uniquePaths(int m, int n) {
        if(m==0 && n==0) return 0;
       vector<int> dp(n,1);
        for(int i = m-2; i>=0; i--){
            for(int j = n-2; j >= 0; j--){
                dp[j] = dp[j+1]+dp[j];
            }
        }
        
        return dp[0];
    }
};

//DFS solution
class Solution {
    vector<vector<int>> memo;
public:
    int uniquePaths(int m, int n) {
        if(m==0 && n==0) return 0;
        memo.resize(m, vector<int> (n));
        memo[m-1][n-1] = 1;
        dfs(0,0, m,n);
        return memo[0][0];
    }
    
    private:
    int dfs(int i , int j, int m, int n){
        if(i == m || j == n) return 0;
        if(memo[i][j] != 0) return memo[i][j];
        memo[i][j] = dfs(i+1, j, m,n) + dfs(i, j+1, m, n);
        return memo[i][j];
    }
};