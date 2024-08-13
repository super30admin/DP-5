# DP-5

## Problem1: (https://leetcode.com/problems/word-break/)

class Solution {
public:
    bool dictContains(string s, vector<string>& wordDict){
        int size = wordDict.size();
        int i;
        for (i=0;i<size;i++){
            if(wordDict[i].compare(s)==0)
                return true;
        }
        return false;
    }
    bool wordBreak(string s, vector<string>& wordDict) {
        int size = s.size();
        if (size == 0)
            return true;
        bool wb[size+1];
        memset(wb, 0, sizeof(wb));
        int i, j;
        for(i=1;i<=size;i++){
            if(wb[i]==false && dictContains(s.substr(0, i), wordDict))
                wb[i] = true;
            if(wb[i]==true){
                if(i==size)
                    return true;
                for(j=i+1;j<=size;j++){
                    if(wb[j]==false && dictContains(s.substr(i, j-i), wordDict))
                        wb[j] = true;
                    if(j==size && wb[j] == true)
                        return true;
                }
            }
        }
        return false;
    }
};

## Problem2: (https://leetcode.com/problems/unique-paths/)

class Solution {
    
    public int uniquePaths(int m, int n) {
        if(m==0 || n==0) return 0;
        if(m==1 || n==1) return 1;

        int[][] dp = new int[m][n];

        //left column
        for(int i=0; i<m; i++){
            dp[i][0] = 1;
        }

        //top row
        for(int j=0; j<n; j++){
            dp[0][j] = 1;
        }

        //fill up the dp table
        for(int i=1; i<m; i++){
            for(int j=1; j<n; j++){
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }

        return dp[m-1][n-1];    
    }
}