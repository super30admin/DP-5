//Time complexity: Sol1: O(2^n) , Sol2: O(n*n*n) : one n is also for generating substring
//Space Complexity: Sol2: O(n)
//Did the code run successfully in LeetCode = yes

package com.madhurima;

import java.util.HashSet;
import java.util.List;

public class WordBreak {
}

class WordBreakSol1 {

    //brute force approach - exhuastive - for based recursion
    public boolean wordBreak(String s, List<String> wordDict) {
        if(wordDict == null || wordDict.size() == 0){
            return false;
        }

        HashSet<String> set = new HashSet<>(wordDict);

        return helper(s, set);

    }

    private boolean helper(String s, HashSet<String> set){
        //base
        if(s.length() == 0){
            return true;
        }

        //logic
        for(int i = 0; i < s.length(); i++){
            if(set.contains(s.substring(0, i+1)) && helper(s.substring(i+1), set)){
                return true;
            }

        }

        return false;
    }
}

class WordBreakSol2 {

    //dp solution
    public boolean wordBreak(String s, List<String> wordDict) {
        if(wordDict == null || wordDict.size() == 0){
            return false;
        }

        HashSet<String> set = new HashSet<>(wordDict);

        int n = s.length();
        boolean[] dp = new boolean[n+1];

        dp[0] = true;

        for(int i = 1; i <= s.length(); i++){
            for(int j = 0; j < i ; j++){
                if(dp[j]){
                    if(set.contains(s.substring(j, i))){
                        dp[i] = true;
                        break;
                    }
                }
            }
        }

        return dp[n];

    }


}
