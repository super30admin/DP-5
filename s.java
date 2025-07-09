class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set < String> wordset = new HashSet<>(wordDict);
        boolean [] dp = new boolean[s.length()+1];
        dp[0]= true; //emptystring made out of zero words
        for(int i=1;i<=s.length();i++){
            for(int j=0 ;j<i;j++){
                // The main rule: check if...
                // 1. The stone we are jumping FROM is safe (dp[j])
                // 2. The jump itself is a valid word (wordSet.contains(...))
                if(dp[j] && wordset.contains(s.substring(j,i))){
                    dp[i]=true;
                    break;
                }
            }
        }
return dp[s.length()];
        
    }
}
//
class Solution {
    public int uniquePaths(int m, int n) {
        int[][] grid = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    grid[i][j] = 1;
                } else {
                    grid[i][j] = grid[i - 1][j] + grid[i][j - 1];
                }
            }
        }
        return grid[m - 1][n - 1];

    }
}