// Time Complexity : O(n^n) n -> length of string
// Space Complexity : O(n), recursive stack space.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Approach1: DFS
//This is a very intuitive approach wherein all characters are checked from left to right. Once a substring existing in dictionary is found, the next string is evaluated recursively.
// This approach is not good because each combination with a particular character is formed and evaluated.
/*
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        if(s == null || s.length() == 0)
            return true;
        // converting a list to set to optimize search
        Set<String> dict = new HashSet<>(wordDict);
        return helper(s,dict);
    }
    
    private boolean helper(String s, Set<String> dict) {
        if(dict.contains(s))
            return true;
        // Iterate over s
        for(int i = 0; i < s.length(); i++) {
            if(dict.contains(s.substring(0,i+1)) && helper(s.substring(i+1), dict))
                return true;
        }
        return false;
    }
}
*/
// Time Complexity : O(n^2) 
// Space Complexity : O(n) auxiliary array to save current state
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Approach2: DP
// In this approach, rather than computing the state of a specific word again and again, an auxiliary array can be used to mark the existence of the word in wordDict.
// Whenever a match is found, the status is updated to true.
// Two pointers are maintained to mark the start and end of the word. If current substring exists in the dictionary and the substring upto that point marked by auxiliary array state is already true, then the string upto current end can be formed using words in the dictionary. 

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        if(s == null || s.length() == 0)
            return true;
        // converting a list to set to optimize search
        Set<String> dict = new HashSet<>(wordDict);
        
        boolean[] isValid = new boolean[s.length()+1];
        isValid[0] = true;
        
        for(int i = 1; i <= s.length(); i++) {
            int j = i;
            while(j <= s.length()) {
                if(isValid[i-1] && dict.contains(s.substring(i-1,j))) {
                    isValid[j] = true;
                }
                j++;
            }
        }
        return isValid[s.length()];
    }
}

