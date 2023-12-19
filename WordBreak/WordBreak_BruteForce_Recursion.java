/* Time Complexity : O(n^n) 
 *  n - len. of string 's' */
/* Space Complexity : O(h)
 * h - height of the recursive stack */

//BruteForce - Recursion

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        return helper(s, set);
    }

    private boolean helper(String s, HashSet<String> set){
        //base
        if(s.length() == 0) return true;
        //logic
        //Exploring all possible substring of the string and then checking if this substring is present in the wordDict(set)
        //If substring is present in the set only then check if remaining string or it's substring is present in the wordDict(set)
        for(int i = 0; i < s.length(); i++){
            String sub = s.substring(0, i + 1);
            if(set.contains(sub) && helper(s.substring(i+1), set)){
                return true;
            }
        }
        return false;
    }
}