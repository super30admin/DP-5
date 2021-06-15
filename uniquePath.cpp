/*
To get all possible paths, we can add up the resutls from the row above and column before.
We need to exhaust all possible combinations, as we need to find all ways.
//////////////////////////////////////////////////////////
Time Complexity: O(M*N)
Space Complexity: O(M*N)
//////////////////////////////////////////////////////////
*/
class Solution {
public:
    int uniquePaths(int m, int n) {
        int dp[m][n];
        for ( int i = 0; i < m; i++){
            dp[i][0] = 1;
        }
        for ( int j = 0; j < n; j++){
            dp[0][j] = 1;
        }
        for ( int i = 0; i < m; i++){
            for ( int j = 0; j < n; j++){
                cout<<dp[i][j]<<" ";
            }
            cout<<endl;
        }
        for ( int i = 1; i < m; i++){
            for ( int j = 1; j < n; j++){
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
};
//////////////////////////////////////////////////////////
//Optimizing Space
//Time Complexity: O(M*N)
//Space Complexity: O(M)
//////////////////////////////////////////////////////////
class Solution {
public:
    int uniquePaths(int m, int n) {
        int dp[n];
        for ( int i = 0; i < n; i++){
            dp[i] = 1;
        }

        for ( int i = m-2; i >= 0 ; i--){
            for ( int j = n-2; j >=0; j--){
                dp[j] = dp[j] + dp[j+1];
            }
        }
        return dp[0];
    }
};
//////////////////////////////////////////////////////////
//Optimizing Space
//Time Complexity: O(M*N)
//Space Complexity: O(min(M,N))
//////////////////////////////////////////////////////////
class Solution {
public:
    int uniquePaths(int m, int n) {
        if ( m < n) return uniquePaths(n, m);
        int dp[n];
        for ( int i = 0; i < n; i++){
            dp[i] = 1;
        }

        for ( int i = m-2; i >= 0 ; i--){
            for ( int j = n-2; j >=0; j--){
                dp[j] = dp[j] + dp[j+1];
            }
        }
        return dp[0];
    }
};