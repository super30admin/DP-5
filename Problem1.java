// Time Complexity : O(n^3) where n is the length of the string
// Space Complexity : O(n^2) for recursive stack and storing the memo
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

/**
 * Using recursive memo solution to check if a subset of string can be made exhaustively using the dictionary words. If it can be made, calling the recursive function with rest of the string
 */
class RecursiveSolution {
    Set<String> memo;
    Set<String> words;

    public boolean wordBreak(String s, List<String> wordDict) {
        this.memo = new HashSet<>();
        this.words = new HashSet<>(wordDict);
        return helper(s);
    }

    private boolean helper(String s) {
        // reached end of the string
        if (s.length() == 0)
            return true;
        if (memo.contains(s))
            return false;

        for (int i = 0; i < s.length(); i++) {
            String currStr = s.substring(0, i + 1);
            //if the current word exists in set and rest of the string can be made recursively, then returning true
            if (words.contains(currStr) && helper(s.substring(i + 1))) {
                return true;
            }
        }

        // exhausted all options for current string and couldn't form the word
        memo.add(s);
        return false;
    }
}


// Time Complexity : O(n^3) where n is the length of the string
// Space Complexity : O(n) for dp array
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

/**
 * Creating a dp array which tracks if the substring ending at i-th character can be made using the words or not at dp matrix i-1 index.
 * Using the inner loop starting from 0 to i index to exhaustively check if the word from 0 to i index can be made or not.
 */
class IterativeDpSolution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() +1];
        dp[0] = true;

        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < i;j++) {
                // if dp[j] == true, only the word before j-th index can be made. If that word cannot be made, we shouldn't go further
                // if rest of the word for indexes [j, i) can be made, then dp[i] will be true
                if (dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                    // don't need to check other paths
                    break;
                }
            }
        }

        return dp[s.length()];
    }
}