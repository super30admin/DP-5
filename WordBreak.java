// In this problem, trying to check substrings of all length whether it is present in word Dict or not. If present, making a 
// recursive call for the remaining substring. 

// Time Complexity : Exponential
// Space Complexity : O(mk) where is the number of words in dict and k is average length of each word
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// This will give time limit exceeded error
// Bruteforce
class Solution {
    // Set for storing the words in wordDict, for O(1) lookup
    HashSet<String> set;

    public boolean wordBreak(String s, List<String> wordDict) {
        // Base case
        if (s == null || s.length() == 0 || wordDict == null) {
            return false;
        }
        // Initialize set and put in wordDict
        set = new HashSet(wordDict);
        // Make the recursive call
        return recurse(s);
    }

    private boolean recurse(String s) {
        // Base
        if (s.length() == 0) {
            return true;
        }
        // Logic
        // Loop till string's length
        for (int i = 0; i < s.length(); i++) {
            // Check if the set contains substring from 0 to i+1, make the recursive call
            // for substr from i+1 to end
            if (set.contains(s.substring(0, i + 1)) && recurse(s.substring(i + 1))) {
                // If that call returns true, return true
                return true;
            }

        }
        // Else false
        return false;
    }
}

// Using dp:
// In this problem, trying to check substrings of all length whether it is
// present in word Dict or not. If present, making a
// recursive call for the remaining substring.

// Time Complexity : O(n^3)
// Space Complexity : O(mk)+O(n) where is the number of words in dict and k is
// average length of each word and n is the length of string s
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
class Solution {
    // Set for storing the words in wordDict, for O(1) lookup
    HashSet<String> set;

    public boolean wordBreak(String s, List<String> wordDict) {
        // Base case
        if (s == null || s.length() == 0 || wordDict == null) {
            return false;
        }
        // Initialize set and put in wordDict
        set = new HashSet(wordDict);
        // Declare dp array which stores 1 if we are somehow able to form substring
        // before that, else 0
        int[] dp = new int[s.length() + 1];
        // An empty substring before the first char is always present in wordDict, so
        // set it to 1
        dp[0] = 1;
        // Loop till string's length
        for (int i = 1; i <= s.length(); i++) {
            // j will go till i to give us the substring
            for (int j = 0; j < i; j++) {
                if (dp[j] == 1) {
                    // Check in set
                    if (set.contains(s.substring(j, i))) {
                        // Set the current dp[i] value to 1 indicating substr present in set
                        dp[i] = 1;
                        // Break
                        break;
                    }
                }
            }
        }
        // At last cell, if 1 then return true
        if (dp[s.length()] == 1) {
            return true;
        }
        // Else false
        return false;

    }
}