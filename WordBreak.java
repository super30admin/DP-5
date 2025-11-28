// 139. Word Break
// https://leetcode.com/problems/word-break/description/


// Solution 1 => Recursion + Memoization

/**
 * Time Complexity: O(2^n) 
 * Space Complexity: O(n)
 */

// We try to create all possible partitions using recursion
// If the current partition is available in wordDict (we convert to set), we pass remaming string to create partitions
// We memoize the strings in set which failed to create valid partiton

class Solution {

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        Set<String> memoSet = new HashSet<>();

        return helper(s, 0, set, memoSet);
    }

    private boolean helper(String s, int pivot, Set<String> set, Set<String> memoSet) {
        // base
        if (pivot >= s.length()) {
            return true;
        }

        if(memoSet.contains(s.substring(pivot, s.length()))){
            return false;
        }

        // logic

        for (int i = pivot; i < s.length(); i++) {

            String substr = s.substring(pivot, i + 1);

            if (set.contains(substr)) {
                if (helper(s, i + 1, set, memoSet)) {
                    return true;
                } 
            }
        }

        memoSet.add(s.substring(pivot, s.length()));

        return false;
    }
}

// Solution 2 => Tabulation

/**
 * Time Complexity: O(n^2) 
 * Space Complexity: O(n)
 */

/**
 * Approach: We maintain a dp array of size n+1 initially set to false.
 *  Each index repesents, whether the string before it can be partitioned as per words in wordDict
 *  At first index i.e 0th index, since we have no string before it, we set to true 
 *  We take 2 pointers, i and j. 
 *  i checks whether string before i is can be partitioned correctly
 *  j starts from 0, since we check all possible strings from start to j
 *  We set i to true, if the entire string before i can be partitioned correcly
 */

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet(wordDict);

        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        for(int i = 1 ; i < dp.length ; i++){
            for(int j = 0 ; j < i ; j++){
                if(dp[j] == true && set.contains(s.substring(j, i))){
                    dp[i] = true;
                }
            }
        }

        return dp[s.length()];
    }
}