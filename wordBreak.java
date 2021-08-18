
//brute force
//TC: O(N^N)
//SC: O(N)
//where N is the length of string
  class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        if(s == null || s.length() == 0)
            return false;
        //build a set
        Set<String> set = new HashSet<>(wordDict);
        
        return helper(s,set);
    }
    private boolean helper(String s,Set<String> set){
        //base 
        if(s.length() == 0)
            return true;
        //logic
        for(int i=0;i<s.length();i++){
            if(set.contains(s.substring(0,i+1)) && helper(s.substring(i+1),set))
                return true;
        }
        return false;
    }
}


//DP approach

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        if(s == null || s.length() == 0)
            return false;
        //build a set
        Set<String> set = new HashSet<>(wordDict);
        int n = s.length();
        boolean[] dp = new boolean[n+1];
        dp[0] = true;
        
        for(int i=1;i<=n;i++){
            for(int j=0;j<i;j++){
                if(dp[j] && set.contains(s.substring(j,i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
   
}
