import java.util.HashSet;
import java.util.List;

//Time complexity- O(n ^ 4)
//Space Complexity- O(n)
//Sucessfully ran on leetcode


class Solution {
 public boolean wordBreak(String s, List<String> wordDict) {
     if(wordDict == null || wordDict.size() == 0) return false;
     
     HashSet<String> set = new HashSet<>(wordDict);
     int n = s.length();
     boolean [] dp = new boolean[n+1];
     dp[0]= true;
     
     for(int i = 1 ; i< n+1 ; i++){
         for(int j = 0; j<i ; j++){
             if(dp[j]){
                 if(set.contains(s.substring(j,i))){
                     dp[i]= true;
                     break;
                 }
             }
         }
     }
     return dp[n];
 }
}