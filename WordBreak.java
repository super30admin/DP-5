// Time Complexity : O(n^3)
// Space Complexity : O(n+k) n = lenght of string ; k = length of wordDict;
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

// Initialization: Convert wordDict to a HashSet for quick lookups, and initialize a boolean array dp to keep track of valid segmentations.
//Dynamic Programming: For each position i in the string s, check all possible substrings ending at i and update dp[i] if a valid word is found.
//Result: Return dp[n] to determine if the entire string s can be segmented into words from the dictionary.

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        if(s== null || s.length() == 0){
            return true;
        }
        HashSet<String> set = new HashSet<>(wordDict);
        int n = s.length();
        boolean dp[] = new boolean[n+1];
        dp[0] = true;
        for(int i = 1; i < n+1 ; i++){
            for(int j=0; j < i ; j++){
                if(dp[j] == true){
                    if(set.contains(s.substring(j,i))){
                        dp[i] = true;
                        break;
                    }
                }
            }
        }
        return dp[n];
    }
}