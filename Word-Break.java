

// Time Complexity : Exponential
// Space Complexity : O(mk) where is the number of words in dict and k is average length of each word
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Bruteforce
class Solution {
    
    HashSet<String> set;

    public boolean wordBreak(String s, List<String> wordDict) {
        // Base case
        if (s == null || s.length() == 0 || wordDict == null) {
            return false;
        }
       
        set = new HashSet(wordDict);
       
        return recurse(s);
    }

    private boolean recurse(String s) {
        // Base
        if (s.length() == 0) {
            return true;
        }
       
        for (int i = 0; i < s.length(); i++) {
            
            if (set.contains(s.substring(0, i + 1)) && recurse(s.substring(i + 1))) {
               
                return true;
            }

        }
       
        return false;
    }
}

// Using dp:


// Time Complexity : O(n^3)
// Space Complexity : O(mk)+O(n) where is the number of words in dict and k is
// average length of each word and n is the length of string s
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
class Solution {
    // Set for storing the words in wordDict, for O(1) lookup
    HashSet<String> set;

    public boolean wordBreak(String s, List<String> wordDict) {
       
        if (s == null || s.length() == 0 || wordDict == null) {
            return false;
        }
      
        set = new HashSet(wordDict);
      
        int[] dp = new int[s.length() + 1];
       
        dp[0] = 1;
       
        for (int i = 1; i <= s.length(); i++) {
          
            for (int j = 0; j < i; j++) {
                if (dp[j] == 1) {
                   
                    if (set.contains(s.substring(j, i))) {
                       
                        dp[i] = 1;
                        // Break
                        break;
                    }
                }
            }
        }
        
        if (dp[s.length()] == 1) {
            return true;
        }
     
        return false;

    }
}