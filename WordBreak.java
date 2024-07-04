import java.util.HashSet;
import java.util.List;

//Time complexity: O(l^ 3) + O(m *n) where l is the length of the string s  and m is the avg length of each word in the dictionary
//and n is the number of words in the dictionary
//Space complexity: O(l + (m*n)) (for the dp array) where l is the length of the string s and m is the avg length of each word in the dictionary
//and n is the number of words in the dictionary
//Did it run on Leetcode: yes
public class WordBreak {
    private TrieNode root;
    class TrieNode{
        private TrieNode[] children;
        private boolean isWordEnd;
        public TrieNode(){
            this.children = new TrieNode[26];
        }
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        if(s == null || s.length() == 0){
            return false;
        }
        this.root = new TrieNode();
        for(String word: wordDict){
            insertWordIntoDictionary(word);
        }
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        for(int i=1; i<=s.length(); i++){
            if(isPresentInTheDictionary(s.substring(0, i))){
                dp[i] = true;
            }else{
                for(int k = i-1; k>=0; k--){
                    if(dp[k] && isPresentInTheDictionary(s.substring(k, i))){
                        dp[i] = true;
                    }
                }
            }
        }
        return dp[s.length()];
    }

    private void insertWordIntoDictionary(String word){
        TrieNode current = this.root;
        for(int i=0; i<word.length(); i++){
            char currentChar = word.charAt(i);
            if(current.children[currentChar-'a'] == null){
                current.children[currentChar-'a'] = new TrieNode();
            }
            current = current.children[currentChar-'a'];
            if(i == word.length() - 1){
                current.isWordEnd = true;
            }
        }
    }

    private boolean isPresentInTheDictionary(String word){
        TrieNode current = this.root;
        for(int i=0; i<word.length(); i++){
            char currentChar = word.charAt(i);
            if(current.children[currentChar-'a'] == null){
                return false;
            }
            current = current.children[currentChar-'a'];
        }
        return current.isWordEnd;
    }





    //exhaustive brute force solution
    //Time complexity: O( l! ) + O(m *n ) where l is the length of the string
    //Space complexity: O(l) + O(m * n) (for the recursive stack space) where l is the length of the string s  and m is the avg length of each word in the dictionary
    //and n is the number of words in the dictionary
    //Did it run on Leetcode: Time limit exceeded
    public boolean wordBreakBruteForce(String s, List<String> wordDict) {
        if(s == null || s.length() == 0){
            return false;
        }
        HashSet<String> wordSet = new HashSet<>();
        for(String word: wordDict){
            wordSet.add(word);
        }
        return canSegment(s, wordSet, 0);
    }

    private boolean canSegment(String s, HashSet<String> wordSet, int idx){
        if(idx == s.length()){
            return true;
        }
        for(int i=0; idx + i < s.length(); i++){
            String currentWord = s.substring(idx, idx+i+1);
            if(wordSet.contains(currentWord)){
                if(canSegment(s, wordSet, idx+i+1)){
                    return true;
                }
            }
        }
        return false;
    }
}
