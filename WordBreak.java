/*
Time: O(N^2) where N is length of string s
Space: O(W) where W is number of words in dictionary for set

Approach:
========
1. Use set to reduce lookup time.
2. Use boolean array to indicate end of valid string at that character
3. For every additional character added, backtrack and check for all possibility of dictionary word combinations that can be formed
4. Return true if any one valid combination of words can be formed from string 
*/
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        if(s == null || s.length() == 0) return true;
        
        // for O(1) lookup, add words to set
        Set<String> wordSet = new HashSet<>();
        for(String str: wordDict) 
            wordSet.add(str);
        
        // adding additional char like null to beginning of string
        s = "^"+s;
        
        boolean[] validCheck = new boolean[s.length()];
        validCheck[0] = true;
        
        /* Recurrence relation: isValid(s[i...n]) = s[k..n] + isValid(0...k)
            Check for all valid possible strings that can be formed using words in dictionary
        */
        for(int i = 1; i < s.length(); i++) {
            int k = i;
            // c, a, ca, t, at, cat, s, ts, ats, cats etc... (go back check for valid string possibility and mark true if it is)
            while(k >= 1) {
                if(wordSet.contains(s.substring(k, i+1)) && validCheck[k-1]) {
                    validCheck[i] = true;
                    break;
                }
                k--;
            }            
        }
        return validCheck[s.length()-1];
    }
}