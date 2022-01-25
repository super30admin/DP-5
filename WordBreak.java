// Time Complexity : O (N3)
// Space Complexity : O (N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

//At each character i , check if i-1 string is present in set. If yes, make dp[i] as 1 .
// If not present, forward j pointer and for dp[j]==1 , then check if rest of substring is there in set.

class Solution {
    
    public boolean wordBreak(String s, List<String>wordDict){
        
        if(s==null || s.length()==0) return true;
        HashSet<String> set=new HashSet<>(wordDict);
        
        boolean dp[]=new boolean[s.length()+1];
        dp[0]=true;
        
        for(int i=1;i<=s.length();i++){
            
            for(int j=0;j<i;j++){
                
                if(dp[j]){
                    
                    if(set.contains(s.substring(j,i)))
                        dp[i]=true;
                }
            }
        }
        
        return dp[s.length()];
        
    }
}