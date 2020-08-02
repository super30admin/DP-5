// Time Complexity : O(s^2) considering linear time needed for search in hashset , s = length of string s
// Space Complexity : O(w), w = length of wordDict
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

/** more efficient implementation will be using trie instead of hash set
 * 
 * https://leetcode.com/problems/word-break/
 * 
 */
class Solution {
    Set<String> set;
    public boolean wordBreak(String s, List<String> wordDict) {
        if(s.length() == 0) return true;
        set = new HashSet<>(wordDict);
        
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for(int i=0; i< s.length()+1 ; i++) {
            
            for(int j=0; j< i; j++) {
                if(dp[j] && set.contains(s.substring(j, i))){
                    dp[i] = true;
                }
            }
        }
        return dp[dp.length-1];
        
    }
    
    //brute force
    private boolean helper(String s) {
        //base
        if(s.length() == 0) return true;
        
        //logic
        for(int i=0 ; i<=s.length() ; i++) {
            if(set.contains(s.substring(0,i)) && helper(s.substring(i))){
                return true;
            }
        }
        return false;
    }
}