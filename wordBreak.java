// approch 1 
// Time Complexity : O(2^n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// approch 2
// Time Complexity : O(n^2)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

//approch 3
// Time Complexity : O(n^2)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

import java.util.*;

class Main {

    // approch 1 using recursion(brute force)
    // set for storing sict words
    private static HashSet<String> set;

    public static boolean wordBreak1(String s, List<String> wordDict) {
        set = new HashSet<>(wordDict);
        return helper1(s);
    }

    private static boolean helper1(String s) {
        // base case
        // if string becomes null we return true as all the substring are
        // in dict
        if (s.length() == 0)
            return true;

        // main logic
        // for loop based recursion
        for (int i = 0; i < s.length(); i++) {
            // take a substring of the starting characters
            String sub = s.substring(0, i + 1);
            // check if substring is in the dict or not
            // if not we continue for loop until it is in dict
            // after that we recurse on the remaining string
            if (set.contains(sub) && helper1(s.substring(i + 1))) {
                return true;
            }
        }
        // if there is no match in the dict we return false
        return false;
    }

    // approch 2 using memorization
    // boolean array for memorization
    private static Boolean[] memo;

    public static boolean wordBreak2(String s, List<String> wordDict) {
        memo = new Boolean[s.length()];
        set = new HashSet<>(wordDict);
        return helper2(0, s);
    }

    private static boolean helper2(int idx, String s) {
        // base case
        // if idx == string length we return true as there is no further string left
        if (s.length() == idx)
            return true;

        // main logic

        // check at particular index we have already found substring is in the dict or
        // not by checking its index
        // using memo table
        if (memo[idx] != null) {
            return memo[idx];
        }
        // for loop based recursion
        for (int i = idx; i < s.length(); i++) {
            // take a substring of the starting characters
            String sub = s.substring(idx, i + 1);
            // check if substring is in the dict or not
            // if not we continue for loop until it is in dict
            // after that we recurse on the remaining string
            if (set.contains(sub) && helper2(i + 1, s)) {
                // here we make idx true as we found substring in the dict at idx
                memo[idx] = true;
                return true;
            }
        }
        // if there is no match in the dict we return false and also make memo ind false
        memo[idx] = false;
        return false;
    }

    // approch 3 bottom up dp
    public static boolean wordBreak3(String s, List<String> wordDict) {
        int n = s.length();
        // set for wordDict
        HashSet<String> set = new HashSet<>(wordDict);
        // dp array
        boolean[] dp = new boolean[n + 1];
        // intially dp[0] is true
        dp[0] = true;
        // traverse in the string
        for (int i = 1; i <= n; i++) {
            // in second loop we are traversing from start to i
            for (int j = 0; j < i; j++) {
                // here we check if previos substring is in the wordDict
                // we will check remaining string if it is in the wordDict
                // then we update the dp[i] as it will show that previous sub string
                // is already in the wordDict
                if (dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        String s = "leetcode";
        String[] d = new String[] { "leet", "code" };
        List<String> wordDict = Arrays.asList(d);
        System.out.println(wordBreak1(s, wordDict));
        System.out.println(wordBreak2(s, wordDict));
        System.out.println(wordBreak3(s, wordDict));

    }
}