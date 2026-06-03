// Time Complexity : O(n²) because for each starting index we try all possible substring endings once due to memoization
// Space Complexity : O(n) for memoization and recursion stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
// We use backtracking to try all possible word breaks starting from the current index.
// A HashSet allows O(1) lookup to check whether a substring exists in the dictionary.
// Memoization stores indices that have already failed, preventing repeated exploration of the same subproblems.

class Solution {

    HashSet<String> set;

    int[] memo;

    public boolean wordBreak(String s, List<String> wordDict) {

        this.set = new HashSet<>(wordDict);

        this.memo = new int[s.length()];

        return helper(s, 0);
    }

    private boolean helper(String s, int pivot) {

        // successfully segmented entire string
        if (pivot == s.length()) {
            return true;
        }

        // already known to fail
        if (memo[pivot] == 1) {
            return false;
        }

        // try all possible cuts
        for (int i = pivot; i < s.length(); i++) {

            String sub = s.substring(pivot, i + 1);

            if (set.contains(sub)) {

                if (helper(s, i + 1)) {
                    return true;
                }
            }
        }

        // mark this index as failed
        memo[pivot] = 1;

        return false;
    }
}