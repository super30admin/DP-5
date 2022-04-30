//Bottom-Up DP

//TC : O(M*N)
//SC : O(M*N)
class Solution {
    public int uniquePaths(int m, int n) {
        if(m == 0 && n == 0)    return 0;
        int[][] data = new int[m+1][n+1];
        
        data[m-1][n-1] = 1;
        
        for(int i = m-1; i>=0; i--){
            for(int j = n-1; j>=0; j--){
                if(i == m-1 && j == n-1)    continue;
                data[i][j] = data[i][j+1] + data[i+1][j];
            }
        }
        return data[0][0];
    }
}



/*
//Top-Down DP
//TC : O(M*N)
//SC : O(M*N)

class Solution {
    int[][] data;
    public int uniquePaths(int m, int n) {
        if(m == 0 && n == 0)    return 0;
        
        data = new int[m][n];
        return find(0, 0, m, n);
        
    }
    public int find(int i, int j, int m, int n){
        //Base case
        if(i == m-1 && j == n-1)    return 1;
        if(i < 0 || i >= m || j < 0 || j >= n)    return 0;
        
        if(data[i][j] == 0){
            data[i][j] = find(i+1, j, m, n) + find(i, j+1, m, n);
        }
        
        
        return data[i][j];
    }
}

*/



/*

//TC : 2^N -- Tim e limit exceeded
class Solution {
    public int uniquePaths(int m, int n) {
        if(m == 0 && n == 0)    return 0;
        
        return dfs(0, 0, m, n);
    }
    public int dfs(int i, int j, int m, int n){
        //Base case
        if(i == m-1 && j == n-1)    return 1;
        if(i < 0 || i >= m || j < 0 || j >= n)    return 0;
        
        return dfs(i+1, j, m, n) + dfs(i, j+1, m, n);
        
    }
}


*/