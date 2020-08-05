// Time Complexity : O(n^n) --> where n is the length of input string
// Space Complexity : O(m) --> where m is the length of input list
// Did this code successfully run on Leetcode (139): Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    HashSet<String> set;
    public boolean wordBreak(String s, List<String> wordDict) {
        set = new HashSet<>(wordDict);
        return helper(s);
    }
    
    private boolean helper(String s) {
        // base
        if (s.length() == 0) return true;
        // logic
        for (int i = 0; i <= s.length(); i++) {
            if (set.contains(s.substring(0, i)) && helper(s.substring(i))) return true;
        }
        return false;
    }
}