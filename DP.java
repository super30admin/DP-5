import java.util.*;
public class DP{
        //time complexity : N^2
    // space complexity : N
    // any doubts : no 
    // did it run on leetcode : yes
    // https://leetcode.com/problems/word-break/
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length()+1];
        dp[0]= true;
        for(int i =1;i<dp.length;i++){
            for(int j =0;j<i;j++){
                if(dp[j] && set.contains(s.substring(j,i))){
                    dp[i]= true;
                }
            }
        }
        
        return dp[dp.length-1];
    }

        // time complexity : M*N
    // space complexity : N
    // did it run on leetcode : yes
    // any doubts : no 
    //https://leetcode.com/problems/unique-paths/
    public int uniquePaths(int m, int n) {
        //int[][] dp = new int[m+1][n+1];
        int[] dp = new int[n+1];
        for(int i =m-1;i>=0;i--){
            for(int j =n-1;j>=0;j--){
                if(i==m-1 && j==n-1){
                    dp[j]= 1;
                }else{
                    dp[j]= dp[j+1]+dp[j];
                }
            }
        }
        
//         for(int i =dp.length-2;i>=0;i--){
//             for(int j = dp[0].length-2;j>=0;j--){
//                 if(i==dp.length-2 && j==dp[0].length-2 ){
//                     dp[i][j]=1;
//                 }else{
                    
//                     dp[i][j]= dp[i+1][j]+dp[i][j+1];
//                 }    
                
//             }
//         }
     
        return dp[0];
        
    
    }
}