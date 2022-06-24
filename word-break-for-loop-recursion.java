import java.util.*;

class Solution {
    // Brute force solution - for loop based recursion
    // Time complexity is O(2^L) where L is the length of the string
    // Space complexity is O(L)
    // This solution gives time limit exceed
    HashSet<String> set;
    boolean isValid;
    public boolean wordBreak(String s, List<String> wordDict) {
        // Edge case
        if(s == null || s.length() == 0) return false;
        set = new HashSet<>(wordDict);
        helper(s);
        return isValid;
    }
    
    private void helper(String s){
        // base case
        if( s.length() == 0){
            isValid = true;
            return;
        }
        // logic
        for(int i = 0; i<s.length(); i++){
            String sub = s.substring(0,i+1);
            if(set.contains(sub)){
                helper(s.substring(i+1));
            }
        }
    }
}