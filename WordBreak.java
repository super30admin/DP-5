// Time Complexity : O(n^2 + m) where n is the length of the string and m is the number of words in dictionary
// Space Complexity : O(n) where n is the length of the string
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None
/* Your code here along with comments explaining your approach: We mark the first cell as true. as the i pointer moves, we take the substring from j to i and
check the substring in the hashset whether it contains the substring and mark the ith position as true. If the dp[j] is true, substring is not in the set
move the j pointer and create the substring to check if the set contains the substring further. Here we are exploring the word in the recursion tree further.
*/

// DP APPROACH
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        if(s == null){return false;}
        HashSet<String> set = new HashSet<>(wordDict);                                      // list to set to facilitate O(1) lookup
        boolean[] dp =  new boolean[s.length()+1];
        dp[0] = true;                                                                               // set the first position as true
        int j = 0;
        for(int i = 1; i < dp.length; i++)
        {   j = 0;
            while(j < i){                                                                       // move the j pointer till i
            if(dp[j] && set.contains(s.substring(j, i))){                                       // Till dp[j] is true and substring exists in the set 
                dp[i] = true;                                                                   // Set contains the word
                break;
            } 
                j++;                                                                            // set doesnt contain the substring
            }
        }
        return dp[dp.length-1];                                                                 // return the result
    }
}

// BRUTE FORCE
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        if(s == null){return false;}
        HashSet<String> set = new HashSet<>(wordDict);                                          // list to set => O(1) lookup
        return helper(s, set);
    }
    private boolean helper(String s, HashSet<String> set){        
        if(s.length()==0){return true;}                                                             // break the recursion
        for(int i= 0; i <= s.length(); i++){
        if(set.contains(s.substring(0, i)) && helper(s.substring(i), set)){                         // if set contains the word and create the substring 0 to ith position
            return true;
        }
    }
        return false;                                                                               // return the result
    }
}