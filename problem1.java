// Time Complexity : O(mn^2)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : i am a bit fuzzy on the logic.

/*
Approach 
we are taking the boolean dp array of len+1 as at 0 making a word ill be true

we start from 1 to dp len in the outer loop we will use this loop to do the comparasion backwards
suppose "leet" we palce i at 1 "e" and j at 0 "l" to we do the loop from "l" to "e"
in the inner loop we make substring as check if that substring is in worddirect set or not and we also check if
if dp[j]is not true that mean we words break can happen there
in the end true dp last value that will show f we take the full string will it be broken into words in the dict or not
*/

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                }
            }
        }
        return dp[dp.length - 1];
    }
}