// O(n^3) time: n is length of input string, n for recursion, n for substring, n for loop
// O(n) space: depth of recursion tree can go up to n

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        return helper(s, new HashSet<>(wordDict), 0, new Boolean[s.length()]);
    }
    
    private boolean helper(String s, Set<String> wordDict, int start, Boolean[] memo){
        if (start == s.length()) return true; // word break on empty
        
        if (memo[start] != null) return memo[start];
        
        for (int end = start + 1; end <= s.length(); end++){
            if (wordDict.contains(s.substring(start, end)) && helper(s, wordDict, end, memo)){
                return memo[start] = true;
            }
        }
        return memo[start] = false;
    }
}