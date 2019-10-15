// Time complexity: O(mn)
// Space complexity: O(mn)

// Approach: keep a 2D dp array. The number of ways to reach a cell (i,j) where i>0 and j>0 is given by,
// number of unique paths to top cell + number of unique paths to left cell

class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        
        for(int i=0;i<m;i++){
            dp[i][0] = 1;
        }
        
        for(int j=0;j<n;j++){
            dp[0][j] = 1;
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                dp[i][j] = dp[i][j-1]+dp[i-1][j];
            }
        }
        return dp[m-1][n-1];
    }
}

// Time complexity: O(s.length * s.length) in worst case
// Space complexity: O(s.length)

// Approach: To check if a word is breakable, 
// check if its substring of say (0,i) is breakable and if substring from i+1 to end of word is in dictionary.
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        for(int i=0;i<s.length();i++){
            for(int j=i-1;j>=-1;j--){
                if(dp[j+1] && wordDict.contains(s.substring(j+1,i+1))){
                    dp[i+1] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
