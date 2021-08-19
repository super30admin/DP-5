// Time Complexity : O(n^n), n = length of string
// Space Complexity : O(n), n = number of words in dictionary
// Did this code successfully run on Leetcode : Yes

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        if(s == null || s.length() == 0)
            return false;
        Set<String> set = new HashSet<>(wordDict);
        return helper(s, set);
    }
    private boolean helper(String s, Set<String> set) {
        //base case
        if(s.length() == 0) return true;
        for(int i=0; i<s.length(); i++) {
            if(set.contains(s.substring(0,i+1)) && helper(s.substring(i+1), set))
                return true;
        }
        return false;
    }
}