/*
Problem: https://leetcode.com/problems/word-break/
*/

// TC: O(n^3) - for the two loops + substring()
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        boolean dp[] = new boolean[len + 1];
        dp[0] = true;
        HashSet<String> wordSet = new HashSet<>(wordDict);
        
        for (int i = 1; i <= len; ++i) {
            for (int j = i - 1; j >= 0; --j) {
                // Check dp[j] first to prevent getting substring unnecessarily.
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[len];
    }
}

/*
Other approaches that led to TLE:
Backtracking solution: https://leetcode.com/submissions/detail/701737874/
Trie Solution: https://leetcode.com/submissions/detail/701742632/
*/