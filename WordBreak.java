//Problem 110 : Word Break-> Bottom Up DP
//TC: O(n^3), because of substring
//SC: O(s.length+1);

/*
  Steps: A) Bottom Up DP: 
            1) Create a new array of input string length+1
            2) Assume 1st character of the string has valid partition or split
            3) Traverse over the array and check for each character that substring string before that character has valid partition or not

         B) Recursion:TC:N^N-> Exponential
            Break word in prefix and suffix chunks, if prefix is valid , then check for suffix   
*/

import java.util.*;
class Solution110 {
    public boolean wordBreak(String s, List<String> wordDict) {
        
        //Using DP
        //TC:O(n^3), because of substring
        //SC:O(s.length+1);
        boolean[] dp = new boolean[s.length()+1];
        Set<String> set = new HashSet<>(wordDict);
        
        dp[0] = true;
        for(int i=1;i<dp.length;i++){
            
            for(int j=0;j<i;j++){
                
                if(dp[j] && set.contains(s.substring(j,i))){
                    dp[i] = true;
                    break;
                }
            }
            
        }
        
        return dp[s.length()];
    }
}


//Problem 110 : Word Break : Recursion with Memoization
//TC: O(N^3),because for N input length there will be N word breaks then, for each break there will be "for" loop for processing substrings and then substring which will be O(N^3). Thus recursive*for*substring.
//SC: O(N) for map + O(wordDict size)


/*class Solution {
    private Set<String> set;
    Map<String,Boolean> map;
    public boolean wordBreak(String s, List<String> wordDict) {
        //TC:O(N^3), because for N input length there will be N word breaks then, for each break there will be "for" loop for processing substrings and then substring which will be O(N^3). Thus recursive*for*substring. 
        //||SC:O(N) for map + O(wordDict size)
        set = new HashSet<>(wordDict);
        map = new HashMap<>();
        
        return helper(s);
        
    }
    
    private boolean helper(String s){
        
        //base
        if(s.length()==0){
            return true;
        }
        
        if(map.containsKey(s)){
          return map.get(s);  
        } 
        
        //logic
        for(int i=0;i<s.length();i++){
            
            if(set.contains(s.substring(0,i+1)) && helper(s.substring(i+1))){
                map.put(s,true);
                return true;
            }
            
        }
        map.put(s,false);
        return false;
    }
    
}*/