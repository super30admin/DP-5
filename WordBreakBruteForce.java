// TLE
// TC: O(n^n)
// SC: O(n)

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        if(s == null || s.length() == 0) {
            return false;
        }
        HashSet<String> set = new HashSet<>(wordDict);
        return helper(s, set);
    }
    private boolean helper(String s, HashSet<String> set) {
        if(s.length() == 0) {
            return true;
        }

        for(int i = 1; i <= s.length(); i++) {
            if(set.contains(s.substring(0, i)) && helper(s.substring(i), set)) {
                return true;
            }
        }
        return false;
    }
}