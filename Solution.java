class Solution {
    //o(n^2) time and o(N)space

    public boolean wordBreak(String s, List<String> wordDict) {
        if(s == null) return false;
        HashSet<String> set = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for(int i = 0; i < dp.length;i++){
            for(int j = 0; j < i; j++){
                if(dp[j] && set.contains(s.substring(j, i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[dp.length -1];
    }

    //o(m * n) time and o(m * n) space
    int[][] table;
    public int uniquePaths(int m, int n) {
        if(m == 0 && n == 0) return 0;
        table = new int[m][n];
        table[m-1][n-1] = 1;
        return dfs(m, n, 0, 0);
    }
    private int dfs(int m, int n, int i, int j){
        if(i == m || j == n) return 0;
        if(i == m - 1 && j == n-1) return 1;
        int right = 0;
        if(i < m - 1){
            if(table[i + 1][j] == 0){
                table[i+1][j]= dfs(m,n, i+1, j);
            }
            right = table[i+1][j];
        }
        int bottom = 0;
        if(j < n - 1){
            if(table[i ][j+ 1] == 0){
                table[i][j+ 1]= dfs(m,n, i, j+ 1);
            }
            bottom = table[i][j+ 1];
        }
        return bottom + right;
    }
}