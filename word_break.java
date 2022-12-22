// Time Complexity :- O(n^2) 
// Space Complexity :- O(n) 
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        
        Set<String> wordSet = new HashSet(wordDict);
        boolean isWord[] = new boolean[s.length() + 1];
        isWord[0] = true;
        for (int i = 1; i < s.length() + 1; i++) {
            for (int j = 0; j < i; j++) {
                if (isWord[j] && wordSet.contains(s.substring(j, i))) {
                    isWord[i] = true;
                    break;
                }
            }
        }
        return isWord[s.length()];       
    }
}