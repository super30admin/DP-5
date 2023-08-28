// Time Complexity : O(n*l*l), where n is the length of the string and l is the length of the longest word in the dictionary.
// Space Complexity : O(n*l), where n is the length of the string.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
 * 1. Create a Trie of the words in the dictionary.
 * 2. Create a dp array of size n+1, where n is the length of the string.
 * 3. dp[0] = true, since empty string is always present in the dictionary.
 * 4. For each index i in the dp array, check if substring 0 to j is true and substring j to i is in the dictionary.
 * 5. If both the conditions are true, then dp[i] = true.
 * 5. Return dp[n].
 */

import java.util.List;

class Solution {
    class TrieNode{
        TrieNode[] children;
        boolean isEnd;
        public TrieNode(){
            this.children = new TrieNode[26];
        }
    }

    private void insertWord(TrieNode root, String word){
        TrieNode curr = root;
        for(char ch : word.toCharArray()){
            if(curr.children[ch - 'a'] == null){
                curr.children[ch - 'a'] = new TrieNode();
            }
            curr = curr.children[ch - 'a'];
        }
        curr.isEnd = true;
    }

    private boolean searchWord(TrieNode root, String word){
        TrieNode curr = root;
        for(char ch : word.toCharArray()){
            if(curr.children[ch - 'a'] == null)
                return false;
            curr = curr.children[ch - 'a'];
        }
        return curr.isEnd;
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        TrieNode root = new TrieNode();
        for(String word : wordDict)
            insertWord(root, word);
        
        int n = s.length();
        boolean[] dp = new boolean[n+1];
        dp[0] = true;

        for(int i=1; i<=n; i++){
            for(int j=0; j<i; j++){
                if(dp[j] && searchWord(root, s.substring(j, i)))
                    dp[i] = true;
            }
        }

        return dp[n];
    }
}