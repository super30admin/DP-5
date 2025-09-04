// Time Complexity : O(n * m * length of words) where n is length of s and m is size of dict
// Space Complexity : O(m) for hashsets
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Approach : I added each word and it's length to a hashset. I maintain a dp boolean array, each index represents if I can make all words till this length, for example - 0 reprsents empty string, I can make it, 1 represents substring from s of length 1, it will represent if I can make it or not. The last index represents if I can sucessfully make the whole word s using words from dictionary. Now to fill this out, I iterate such that I only start from points I can make - I can make empty substring at index 0 so I can start, if not, then this is not a start point so I continue. Now the main logic is that I go over each different size and find the substring from this index to index + size and check if my set contains this word - if so, I can mark the end as true. 

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[]dp = new boolean[s.length()+1];
        dp[0]=true;
        HashSet<String> words = new HashSet<>();
        HashSet<Integer> sizes = new HashSet<>();
        // O(m) - m is dict size
        for(String word : wordDict){
            words.add(word);
            sizes.add(word.length());
        }

        // O(n * m * length of words)
        for (int i = 0; i < s.length(); i++) {
            if (!dp[i]) continue;
            // O(m * length of word (for doing the substring))
            for (int size : sizes) {
                int end = i + size;
                if (end <= s.length() && words.contains(s.substring(i, end))) {
                    dp[end] = true;
                }
            }
        }
        return dp[s.length()];
    }   
}