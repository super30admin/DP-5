
/**
LeetCode Submitted : No (Time Limit Exceed Error)
Space Complexity : O(length of String + 1)
Time Complexity : O(length of String * length of String)

The idea is to have a an array of each positions of the string storing all possible matches so we can lookback to those positions and see if we find match for remaining part of string. We have an extra space as we initially assume there is a match so we know where to re-iterate back in case we do not find any possible positions. The first entry of the this array is true indicating we have a match intitially when no substrings are compared.

**/




class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
     
        if(s == null || s.length() < 1)
            return false;
        
        Set<String> set = new HashSet<>(wordDict);
        
        boolean[] dp = new boolean[s.length() + 1];
        
        dp[0] = true; //Always match when no substring is checked.
        
        for(int i = 1; i<dp.length;i++){
            for(int j = 0; j<i;j++){
                if(dp[j] == true && set.contains(s.substring(j,i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        
        //Now see if we found matches by check last position of dp array
        return dp[dp.length - 1];
        
    }
}
