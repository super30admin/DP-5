/*
Did this code successfully run on Leetcode :  Yes
Any problem you faced while coding this :  No
Approach - Bottom up DP
Time complexity - O(n^3)
Space Complexity - O(N + k)
*/

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak_LC_139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}

/* Recursive -TLE
Time complexity - O(2^n)
Space Complexity - O(N + k)
*/
class SolutionRecursive {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        int n = s.length();
        return helper(s,set, 0);

    }
    private boolean helper(String s, HashSet<String> set, int pivot) {
        //base
        if(pivot == s.length()) return true;


        //logic
        for(int i = pivot; i < s.length(); i++) {
            String subStr = s.substring(pivot, i+1);
            if(set.contains(subStr) && helper(s, set, i+1)) {
                return true;
            }
        }
        return false;
    }
}

/* Recursive without pivot - TLE
Time Complexity- 2^n * n
Space Complexity - n^2 + k */
class SolutionRecursiveWithoutPivot {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        int n = s.length();
        return helper(s,set);

    }
    private boolean helper(String s, HashSet<String> set) {
        //base
        if(s.length() == 0) return true;


        //logic
        for(int i = 0; i < s.length(); i++) {
            String subStr = s.substring(0, i+1);
            if(set.contains(subStr) && helper(s.substring(i+1), set)) {
                return true;
            }
        }
        return false;
    }
}

