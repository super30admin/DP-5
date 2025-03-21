// Time Complexity : O(n^2) where n is the length of the string.
// Space Complexity : O(n^2) for memo.
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

import java.util.*;
class Solution {
    private boolean helper(String s, int pivot, Set<String> dict, Boolean[] dp)
    {
        if(pivot >= s.length()) return true;

        if(dp[pivot] != null)
            return dp[pivot];
        
        boolean result = false;
        for(int i=pivot; i<s.length(); i++)
        {
            String temp = s.substring(pivot, i+1);
            if(dict.contains(temp))
                result = result || helper(s, i+1, dict, dp);
        }
        dp[pivot] = result;
        
        return dp[pivot];
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        Boolean[] dp = new Boolean[s.length()];
        Set<String> dict = new HashSet<>(wordDict);
        return helper(s, 0, dict, dp);
    }
}