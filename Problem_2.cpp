//Time: O(NM)
//Space: O(NM)
class Solution {
public:
    int uniquePaths(int m, int n) {
        vector<vector<int>> dp(m+1, vector(n+1, 0));
        for(int i=1;i<dp.size();i++){
            for(int j=1;j<dp[0].size();j++){
                if(i==1 && j==1) {
                    dp[i][j]=1;
                }
                else{
                    dp[i][j]=dp[i-1][j]+dp[i][j-1];
                }
            }
        }
        return dp[m][n];
    }
};