import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Sample {
    /***************************PROBLEM-2********************/
    //top down recursion
//TC:0(2*N)
//SC:0(M+N)
    class Solution {
        private HashMap<Pair<Integer,Integer>,Integer> memo=new HashMap<>();
        public int uniquePaths(int m, int n) {
            if(m==0 || n==0){
                return 0;
            }

            return dp(m,n,0,0);
        }

        private int dp(int m,int n,int row,int col){
            //base
            if(row==m || col==n){
                return 0;
            }
            if(row==m-1 || col==n-1){
                return 1;
            }
            //logic
            if(!memo.containsKey(new Pair<>(row,col))){
                memo.put(new Pair<>(row,col),dp(m,n,row,col+1)+dp(m,n,row+1,col));
            }
            return memo.get(new Pair<>(row,col));
        }
    }

    //TC:0(M*N)
//SC:0(M*N)
    class Solution {
        public int uniquePaths(int m, int n) {
            if(m==0||n==0){
                return 0;
            }

            int[][] dp=new int[m+1][n+1];
            dp[m-1][n-1]=1;
            for(int i=m-1;i>=0;i--){
                for(int j=n-1;j>=0;j--){
                    if(i==m-1 && j==n-1){
                        continue;
                    }
                    dp[i][j]=dp[i+1][j]+dp[i][j+1];
                }
            }
            return dp[0][0];
        }
    }

    //TC:0(M*N)
//SC:0(N)
    class Solution {
        public int uniquePaths(int m, int n) {
            if(m==0||n==0){
                return 0;
            }

            int[] dp=new int[n];
            Arrays.fill(dp,1);
            for(int i=m-2;i>=0;i--){
                for(int j=n-2;j>=0;j--){
                    dp[j]=dp[j+1]+dp[j];
                }
            }
            return dp[0];
        }
    }

    /*******************************PROBLEM-1*************/

    //TC:0(M*M)
//SC:0(N^3)
    class Solution {
        private HashSet<String> set;
        public boolean wordBreak(String s, List<String> wordDict) {
            if(s==null||s.length()==0||wordDict.size()==0){
                return false;
            }
            set=new HashSet<>(wordDict);
            int n=s.length();
            boolean[] dp=new boolean[n+1];
            dp[0]=true;

            for(int i=1;i<dp.length;i++){
                for(int j=0;j<i;j++){
                    if(dp[j]==true){
                        if(set.contains(s.substring(j,i))){
                            dp[i]=true;
                            break;
                        }
                    }
                }
            }
            return dp[dp.length-1];
        }


    }

}
