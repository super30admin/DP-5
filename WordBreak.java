// Time Complexity :  O(N ^ 3) N is the length of s
// Space Complexity : O(N) Set memory usage  
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] f = new boolean[s.length() + 1];
        f[0] = true;
        
        HashSet<String> words = new HashSet<>(wordDict);
        
        for(int i = 1; i <= s.length(); i++){
            for(int j = 0; j < i; j++){
                if(f[j] && words.contains(s.substring(j, i))){
                    f[i] = true;
                    break;
                }
            }
        }
        return f[s.length()];
    }
}