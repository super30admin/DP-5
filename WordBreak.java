// Time Complexity :exponential
// Space Complexity :O(l)recursive stack space
// Did this code successfully run on Leetcode :TLE
// Any problem you faced while coding this :No
//by for loop based recursion, we are checking each possibility of partition
//in the input
class Solution {
    HashSet<String> set = new HashSet<>();
    boolean result;

    public boolean wordBreak(String s, List<String> wordDict) {
        for (String word : wordDict) {
            set.add(word);
        }
        helper(s);
        return result;
    }

    public void helper(String s) {
        // edge

        if (s.length() == 0) {
            result = true;
            return;
        }
        // logic
        for (int i = 0; i < s.length(); i++) {
            String sub = s.substring(0, i + 1);
            if (set.contains(sub)) {
                helper(s.substring(i + 1));
            }
        }
    }
}
// ------------------DP SOLUTION-----------------------------------
// Time Complexity :n^4 if we consider that set will take O(n) to check contains
// in worst case
// where n is length of string we are checking contains in set
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :No

// we are memorizing if string partition is a valid one or not and using that to
// check next partition
// we'll check if partition next to valid partition is valid or not and resturn
// last result
class Solution {

    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>();
        int strLen = s.length();
        boolean[] result = new boolean[strLen + 1];
        for (String word : wordDict) {
            set.add(word);
        }
        result[0] = true;
        for (int i = 1; i < result.length; i++) {
            for (int j = 0; j < i; j++) {
                if (result[j]) {
                    String sub = s.substring(j, i);
                    if (set.contains(sub)) {
                        result[i] = true;
                    }
                }
            }
        }
        return result[strLen];
    }

}