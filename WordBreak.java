/**
 * TC: O(n^3) two nested for loops and substring generation is O(n) in newer versions of Java
 * SC: O(n)
 * LeetCode: Y(https://leetcode.com/problems/word-break)
 * Approach: 
        Brute force: Generate all substrings and check them in dictionary
        DP Approach: Remember if a substring was able to generated and use that the result to determine whether entire substring is generated or not
        
 */

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        
        // Convert given list of words into HashSet for fast access
        Set<String> dictionary = new HashSet<String>(wordDict);
        
        // check edge case
        if(s == null || s.length() == 0) {
            return true;
        }
        
        // Initialize dp array to remember if a substring can be constructed or not
        boolean[] dp = new boolean[s.length() + 1];
        
        // Empty string can always be created
        dp[0] = true;
        
        // Iterate through the dp array
        for(int i = 1 ; i < dp.length ; i++) {
            // Loop from 0 to i
            for(int j = 0 ; j < i ; j++) {
                
                // if the substring [0, j) and [j,i) is present
                if(dp[j] && dictionary.contains(s.substring(j, i))) {
                    // remember that subsstring [0, i) is present
                    dp[i] = true;
                    break;
                }
            }
        }
        // return if the input string is present or not
        return dp[s.length()];
        
    }
}
