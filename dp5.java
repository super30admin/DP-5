//problem1
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set=new HashSet<>(wordDict);
        int n=s.length();
        boolean[] dp=new boolean[n+1];
        dp[0]=true;
        for(int i=1;i<=n;i++){
            for(int j=0;j<i;j++){
                if(dp[j] && set.contains(s.substring(j,i))){
                    dp[i]=true;
                    break;
                }
            }
        }
        return dp[n];
    }
}
//problem2
class Solution {
    public int uniquePaths(int m, int n) {
        int[] dp=new int[n];
        for(int i=m-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                if(i==m-1||j==n-1){
                    dp[j]=1;
                }else{
                dp[j]=dp[j]+dp[j+1];
                }
            }
        }
        return dp[0];
    }
}
