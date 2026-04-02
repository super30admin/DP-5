import java.util.*;

// Recurisve TLE, O(2^n) time, O(n) space
// class Solution {
//     public boolean wordBreak(String s, List<String> wordDict) {
//         Set<String> wordSet = new HashSet<>(wordDict);
//         return helper(0, s, wordSet);
//     }

//     private boolean helper(int pivot, String s, Set<String> wordSet) {

//         if (pivot == s.length()) {
//             return true; // string can be partitioned and valid
//         }

//         for (int i = pivot; i < s.length(); i++) {

//             String substr = s.substring(pivot, i+1);

//             if (wordSet.contains(substr)) {
//                 if (helper(i+1, s, wordSet)) {
//                     return true;
//                 }
//             }
//         }
//         return false;
//     }
// }

// Memoization, O(n^2) time, O(n) space
// class Solution {
//     public boolean wordBreak(String s, List<String> wordDict) {
//         Set<String> wordSet = new HashSet<>(wordDict);
//         Boolean[] dp = new Boolean[s.length()];
//         return helper(0, s, wordSet, dp);
//     }

//     private boolean helper(int pivot, String s, Set<String> wordSet, Boolean[] dp) {

//         if (pivot == s.length()) {
//             return true; // string can be partitioned and valid
//         }

//         if (dp[pivot] != null) return dp[pivot];

//         for (int i = pivot; i < s.length(); i++) {

//             String substr = s.substring(pivot, i+1);

//             if (wordSet.contains(substr)) {
//                 if (helper(i+1, s, wordSet, dp)) {
//                     return true;
//                 }
//             }
//         }
//         dp[pivot] = false;
//         return dp[pivot];
//     }
// }

// Bottom up, O(n^2) time, O(n) space
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];

        dp[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                String substr = s.substring(j, i);
                if (dp[j] && wordSet.contains(substr)) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}