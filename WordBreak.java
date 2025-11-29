// Time Complexity : O(n^3).
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Approach : We create a hashset for the words of the wordDict. We maintain a boolean dp array with two pointers to check, at each position if the
// substring is present in the set and previous one is reachable. IF bith condition satisfy we mark the current position as true and continue. We repeat until
// the end of string s and return the last boolean value.

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict); //hashset to store wordDicts
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;

        for(int i = 1; i <= n; i++){
            for(int j = 0; j < i; j++){
                if(dp[j] && set.contains(s.substring(j, i))){ //check if substring from i to j is in set and previous one was true
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n];
    }
}