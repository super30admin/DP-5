// Time Complexity :O(mn)
// Space Complexity :O(mn)
// Did this code successfully run on Leetcode :yes
class Solution {
    public int uniquePaths(int m, int n) {
        int [][] dp = new int [m+1][n+1];
        for(int i = m-1;i>=0;i--){
            for(int j = n-1;j>=0;j--){
                if(i == m-1 && j == n-1){
                     dp[i][j] = 1;
                }else{
                     dp[i][j] = dp[i+1][j]+dp[i][j+1];
                }
               
            }
        }
        return dp[0][0];
    }
}
// Time Complexity :O(mn)
// Space Complexity :O(n) n is number of columns
// Did this code successfully run on Leetcode :yes
class Solution {
    public int uniquePaths(int m, int n) {
        if(m ==0 || n==0) return 0;
        int [] dp = new int[n];
        Arrays.fill(dp,1);
        for(int i =m-2;i>=0;i--){
            for(int j =n-2;j>=0;j--){
                dp[j] = dp[j] +dp[j+1];
            }
        }
        return dp[0];
    }
}

// Time Complexity :O(n)^n
// Space Complexity :O(n) n is length of the string
// Did this code successfully run on Leetcode :TimeLimitExceed
class Solution {
    HashSet<String> set;
    public boolean wordBreak(String s, List<String> wordDict) {
        set = new HashSet<>(wordDict);
        return helper(s);
    }
    public boolean helper(String s){
        //base
        if(s.length() == 0) return true;
        //logic
        for(int i = 0;i< s.length();i++){
            String sub =s.substring(0,i+1);
            if(set.contains(sub) && helper(s.substring(i+1))) return true;
        }
        return false;
    }
}
// Time Complexity :O(nk)
// Space Complexity :O(n) n is length of the string
// Did this code successfully run on Leetcode :yes
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
       HashSet<String> set = new HashSet<>(wordDict);
        boolean [] dp = new boolean[s.length()+1];
        dp[0] = true;
        for(int i =0;i<dp.length;i++){
            for(int j = 0;j<=i;j++){
                if(dp[j] && set.contains(s.substring(j,i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[dp.length-1];
    }
}
