/**
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, 
 * determine if s can be segmented into a space-separated sequence of one or more dictionary words.
 * 
 * A naive approach which only works for set of strings having no common prefixes is where we have a pass,
 * over the input string and keep a window where in we are interested to match the correct window content.
 * Unfortunately, this does not work for cases like {"the", "there", "dog"}, s = "theredog";
 * According to this approach 'the' of input is parsed and then we cannot match the remaining string correctly.
 * We can make this complete, by using backtracking where, if we fail at some point in parsing the string, we back track.
 * Time Complexity of this solution would be exponential :/
 * 
 * Can we do better? Overlapping subproblems, use dp :)
 * Idea from CKY parsing studied in natural language processing course, where in we maintain a 2D matrix,
 * each cell i,j represents whether s[i...j] is a valid parse or not.
 * Time Complexity: O(n^3)
 * Space Complexity: O(n^2)
 * 
 * We can further optimize it to use linear space.
 * Each cell indicates whether string from beginning until this position is a successful parse or not.
 * In order to compute the same, all we need is to walk j backwards until the first position which is parsed sucessfully,
 * and the remainder until this point i, is in dictionaty;
 * 
 * Space Complexity: O(n) for dp array, O(k*n) for the hashset.
 * Time Complexity: O(k*n^2), k is for lookup in sets
 * 
 * 
 * Leetcode Result:
 * Runtime: 2 ms, faster than 94.14% of Java online submissions for Word Break.
 * Memory Usage: 35.6 MB, less than 99.28% of Java online submissions for Word Break.
 */

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>();
        for(String word: wordDict) {
            set.add(word);
        }
        
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        
        for(int i = 0; i < s.length(); i++) {
            int j = i;
            while(j >= 0) {
                if(dp[j] && set.contains(s.substring(j, i+1))) {
                    dp[i+1] = true;
                    break;
                }
                j--;
            }
        }

        return dp[s.length()];
    }
}