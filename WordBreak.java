// Time Complexity : exponential
// Space Complexity : O(length of dictionary)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Approach

// We try solving it using recursion
// At everypoint we take the substring and check in the hashset
// As it is exponential TC, we will get timelimit exceeded

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || s.length() == 0)
            return true;
        HashSet<String> set = new HashSet<>(wordDict);
        return helper(s, set);
    }

    public boolean helper(String s, HashSet<String> set) {
        if (s.length() == 0)
            return true;

        for (int i = 1; i <= s.length(); i++) {
            if (set.contains(s.substring(0, i)) && helper(s.substring(i), set)) {
                return true;
            }
        }
        return false;
    }
}

// Time Complexity : O((mn)^4)
// Space Complexity : O(n) + O(length of dictionary)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Approach

// We solve this using dp
// we create a 1d dp array, to manage the repeated subproblems
// We iterate through the string and whenever we find a substring in the set we
// mark it in the dp
// we skip the substrings that do are not in the set

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || s.length() == 0)
            return true;
        HashSet<String> set = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] == true) {
                    if (set.contains(s.substring(j, i))) {
                        dp[i] = true;
                    }
                }
            }
        }
        return dp[s.length()];
    }

}