import java.util.List;

public class WordBreak {
    //Time complexity: O(n^2 + m⋅k) n = length of string, m.k = dictionary
    //space complexity: O(mk + n)
    class TrieNode{
        boolean isComplete;
        TrieNode[] children;
        TrieNode(){
            this.children = new TrieNode[26];
            this.isComplete = false;
        }
    }
    TrieNode root;

    private void insert(String str){
        TrieNode current = root;
        for(int i =0; i< str.length(); i++){
            char ch = str.charAt(i);
            if(current.children[ch - 'a'] == null){
                current.children[ch - 'a'] = new TrieNode();
            }
            current = current.children[ch - 'a'];
        }
        current.isComplete = true;
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        root = new TrieNode();
        TrieNode current = root;

        for(String curr: wordDict){
            insert(curr);
        }

        boolean[] dp = new boolean[s.length()];
        for(int i = 0; i < s.length(); i++){

            if(i==0 || dp[i -1 ]){
                current = root;
                for(int j = i ; j< s.length(); j++){
                    char ch = s.charAt(j);
                    if(current.children[ch - 'a'] == null) break;

                    current = current.children[ch - 'a'];
                    if(current.isComplete) dp[j] = true;

                }
            }
        }


        return dp[s.length() - 1];
    }
}
