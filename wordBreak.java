// Time Complexity = O(n^4)
// Space Complexity = O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        if(s == null || s.length() == 0) return true;

        Set<String> set = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;

        //i: Traverse through the dp array and check if the words till that point are a part of the set
        //j: move j from 0 to i for every i and check when dp[j] == true that the substring from j to i is a part of the set
        // if yes, then update dp[i] as true.
        for (int i=1; i<=s.length(); i++) {
            for (int j=0; j<i; j++) {
                if (dp[j] == true && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                }
            }
        }

        // the final spot will have the answer since the alphabets have ended and
        // the broken words should be already present in the set
        return dp[s.length()];
    }
}