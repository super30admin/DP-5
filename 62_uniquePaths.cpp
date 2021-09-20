// Time Complexity : exponential
// Space Complexity :O(M*N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


class Solution {
public:
    int uniquePaths(int m, int n) {
        if(m==0 || n==0)
            return 0;
        return helper(0, 0, m, n);
    }
    
    int helper(int row, int col, int m, int n){
        //base
        if(row == m || col == n)
            return 0;
        if(row == m-1 && col == n-1)
            return 1;
        
        //logic
        return helper(row, col+1, m, n) + helper(row+1, col, m, n);
    }
};

// Time Complexity : O(M*N)
// Space Complexity :O(M*N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
public:
    int uniquePaths(int m, int n) {
        if(m==0 || n==0)
            return 0;
        vector<vector<int>> dp(m, vector<int> (n));
        for(int i=m-1; i>=0; i--){
            for(int j=n-1; j>=0; j--){
               if(i == m-1 || j == n-1){
                    dp[i][j] = 1;
                    continue;
               }
                dp[i][j] = dp[i+1][j]+dp[i][j+1];
            }
        }
        return dp[0][0];
    }
};

// Time Complexity : O(M*N)
// Space Complexity :O(N) smaller among m and n
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
public:
    int uniquePaths(int m, int n) {
        if(m==0 || n==0)
            return 0;
        if(n>m)
            return uniquePaths(n, m);
        vector<int> dp(n, 1);
        for(int i=m-2; i>=0; i--){
            int right = 0;
            for(int j=n-1; j>=0; j--){
                dp[j] = right + dp[j];
                right = dp[j];
            }
            
        }
        return dp[0];
    }
};
