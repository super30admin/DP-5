// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set=new HashSet<>();
        for(String word:wordDict){
            set.add(word);
        }
        int[] dp=new int[s.length()];
        Arrays.fill(dp,-1);
        return helper(s,set,0,dp);
    }
    
    public boolean helper(String s, HashSet<String> set,int index,int[] dp){
        if(index==s.length()){
            return true;
        }
        
         if(dp[index]!=-1){
             if(dp[index]==1)return true;
             
             return false;
        }
        for(int i=index;i<s.length();i++){
            String s1=s.substring(index,i+1);
            if(set.contains(s1)){
              
                    boolean rem= helper(s, set,i+1,dp);
                    if(rem==true){
                        dp[i]=1;
                        return true;
                    }
                 
            }
        }
        dp[index]=0;
        return false;
    }
}