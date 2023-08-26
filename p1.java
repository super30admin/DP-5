// Time Complexity :O(l^3) where l is the length of s
// Space Complexity :O(l)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach

class Solution {
    //Using trie to store words
    class Trie{
        boolean isEnd;
        Trie[] children;
        public Trie(){
            this.isEnd = false;
            this.children = new Trie[26];
        }
    }

    Trie head;

    private void insert(String word){
        Trie trie = head;
        for(int i=0; i<word.length(); i++){
            char c = word.charAt(i);
            if(trie.children[c - 'a'] == null){
                trie.children[c - 'a'] = new Trie();
            }
            trie = trie.children[c - 'a'];
        }
        trie.isEnd = true;
    }

    private boolean find(String word){
        Trie trie = head;
        for(int i=0; i<word.length(); i++){
            char c = word.charAt(i);
            if(trie.children[c - 'a'] == null){
                return false;
            }
            trie = trie.children[c - 'a'];
        }
        return trie.isEnd;
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        head = new Trie();
        for(String word: wordDict){
            insert(word);
        }

        // HashSet<String> set = new HashSet<>(wordDict);


        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;

        //Going through every character in s and finding which partition before the character works
        for(int i=0; i<s.length(); i++){
            for(int j=0;  j<=i; j++){
                if(dp[j] && find(s.substring(j,i+1))){
                    dp[i+1] = true;
                    break;
                }
            }
        }

        return dp[s.length()];
    }


}