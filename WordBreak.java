// Time Complexity: O(n.l)
// Space Complexity: O(n)

import java.util.List;

class Solution {
    class TrieNode {
        TrieNode[] children;
        boolean isEnd;

        public TrieNode() {
            this.children = new TrieNode[26];
        }
    }

    TrieNode root;

    private void insert(String s) {
        TrieNode curr = root;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (curr.children[c - 'a'] == null)
                curr.children[c - 'a'] = new TrieNode();
            curr = curr.children[c - 'a'];
        }
        curr.isEnd = true;
    }

    private boolean search(String s) {
        TrieNode curr = root;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (curr.children[c - 'a'] == null)
                return false;
            curr = curr.children[c - 'a'];
        }
        return curr.isEnd;
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        this.root = new TrieNode();
        for (String word : wordDict)
            insert(word);
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;

        for (int i = 1; i <= n; i++)
            for (int j = 0; j < i; j++) {
                String subString = s.substring(j, i);
                if (dp[j] && search(subString))
                    dp[i] = true;
            }

        return dp[n];
    }
}