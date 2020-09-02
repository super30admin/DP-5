// There are two approaches
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

import java.util.HashSet;
import java.util.List;

// Your code here along with comments explaining your approach
// Approach 1: Brute force
// Permute all the combinations of substring
// Time Complexity : O(n^n*n + m) = O(n^n*n)
//      n: length of the string
//      m: length of word dictionary
//   Here n*n -> n choices and n for creating substring
//   m -> For creating HashMap
// Space Complexity : O(n+m) = O(n)
//      n: length of the string
//      m: length of word dictionary
//    n -> recursive stack space
//    m -> HashMap
class Problem1S1 {

    // global hashset
    HashSet<String> mySet;

    /** find all words present in string */
    public boolean wordBreak(String s, List<String> wordDict) {

        // create hashset of word dict
        mySet = new HashSet<>(wordDict);

        // find all substring combinations
        return dfsHelper(s, 0);
    }
    
    /** DFS helper -> creates all combination of substring */
    private boolean dfsHelper(String s, int index){
        
        // base case
        if(index == s.length())
            return true;
        
        // create substring 
        for(int i= index+1; i<= s.length(); i++){

            // check if a particular sub string is present and also remaining substring
            if(mySet.contains(s.substring(index, i)) &&  dfsHelper(s, i)) // n * n
               return true;
        }
        // not found
        return false;
    }
}

// Your code here along with comments explaining your approach
// Approach 2: DP
// Permute all the combinations of substring
// Time Complexity : O(n^3 + m) = O(n^3)
//      n: length of the string
//      m: length of word dictionary
//   3n-> for every character, checking in dp and creating substring
//   m-> creating HashMap
// Space Complexity : O(n+m) = O(n)
//      n: length of the string
//      m: length of word dictionary
//   This dp matrix and HashMap
class Problem1S2 {

    /** find all words present in string  */
    public boolean wordBreak(String s, List<String> wordDict) {
        
        // edge case
        if(s == null || s.length() == 0)
            return true;
        
        // create hash set
        HashSet<String> mySet = new HashSet<>(wordDict);

        // initialize 
        int n = s.length();
        boolean[] dp = new boolean[n+1];
        dp[0] = true; // seed for empty string

        // iterate string
        for(int i = 1; i<dp.length; i++){ // O(n)

            // check for every substring
            for(int j=0; j< i; j++){
                // substring present
                if(dp[j] && mySet.contains(s.substring(j, i))){  // O(n*n)
                    dp[i] = true; // update dp where substring found
                    break;
                }
                    
            }
        }
        // all substring present
        return dp[n];
    }
}