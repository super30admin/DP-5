//tc:
//sc:

class Solution {
    vector<vector<int>> memo;
public:
    int uniquePaths(int m, int n) {
       return dfs(0,0,m,n); 
    }

    private: 
    
    int dfs(int i, int j,int m, int n )
    {
        if(i == m-1 || j == n-1) return 1;

        //base
        if(i == m || j == n) return 0;

        int case0 = 0, case1 = 0;

        if(memo[i+1][j] == 0)
        {
            memo[i+1][j] = dfs(i+1,j,m,n);
        }

        case0 = memo[i+1][j];

        if(memo[i][j+1] == 0)
        {
            memo[i+1][j] = dfs(i,j+1,m,n);
        }

        case1 = memo[i][j+1];

        return case0+case1;

    }
};


///////////////////option 2

class Solution {
public:
    int uniquePaths(int m, int n) 
    {
         vector<int> cur(n, 1);
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                cur[j] += cur[j - 1];
            }
        }
        return cur[n - 1];
    }
};