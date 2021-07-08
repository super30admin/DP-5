// TC : O(n)
// SC :O(n+1)  -- > n is length of the string 

//IDEA: Make the DP boolean array of str lenght +1 
//dp[0] == 1 , since empty sub string is considered as in dictionary.
//Check the left side of the i , ie. sub string from j to i  is in Set, if yes then make dp[i] = true.
/// dp{length -1 } == 1 --> whole string is in dictionary , so return true else false.
 

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean dp[] = new boolean[s.length()+1];
        
        HashSet<String> set = new HashSet<>(wordDict);
        dp[0]=true;
        for(int i=1;i<dp.length;i++){
            for(int j=0;j<i;j++){
                if(dp[j]  && set.contains(s.substring(j,i))){
                    dp[i] = true;
                }
            }            
        }
       return  dp[dp.length-1];
    }
}
