// Problem 139. Word Break
// Time Complexity : O(n*n)
// Space Complexity : O(n*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        Map<String, Boolean> memo = new HashMap<>();
        return helper(s, set, memo);
    }
    private boolean helper(String s, HashSet<String> set, Map<String, Boolean> memo) {
        // base case
        if (s.length() == 0){
            return true;
        }
        if (memo.containsKey(s)){
            return memo.get(s);
        }
        for (int i = 0; i < s.length(); i++) {
            String subst = s.substring(0, i+1);
            if (set.contains(subst) && helper(s.substring(i+1), set, memo)) {
                memo.put(s, true);
                return true;
            }
        }
        memo.put(s, false);
        return false;
    }
}
