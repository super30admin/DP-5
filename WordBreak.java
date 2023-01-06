// Time Complexity : O(n^3)
// Space Complexity :O(ml + n)
// n is the length of given word
// m is the number of words in dictionary
// l is the avg length of each word
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

import java.util.HashSet;
import java.util.List;

//Optimized approach
//TC: O(n^3)
//SC: O(ml + n)
// n is the length of given word
// m is the number of words in dictionary  of avg length l
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;

        for(int i =0 ; i < dp.length ; i++){
            for(int j = 0 ; j < i ; j++){
                if(dp[j] == true && set.contains(s.substring(j,i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}

// Method 1 - Recursion - gives TLE on leetcode
// This is because TC: exponential

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        return helper(s,set);
    }

    private boolean helper(String s, HashSet<String> set){
        //base case
        if(s.length() == 0)
            return true;

        //logic
        for(int i = 0 ; i < s.length() ; i++){
            String sub = s.substring(0,i+1);
            if(set.contains(sub) && helper(s.substring(i+1),set)){
                return true;
            }
        }
        return false;
    }
}