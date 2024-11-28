class Solution {
    Trie root;
    class Trie{
        boolean isEnd;
        Trie[] child;
        public Trie(){
            isEnd=false;
            child=new Trie[26];
        }
    }
    private void insert(String s){
        Trie curr=root;
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(curr.child[c-'a']==null){
                curr.child[c-'a']=new Trie();
            }
            curr=curr.child[c-'a'];
        }
        curr.isEnd=true;
    }
    private boolean search(String s){
        Trie curr=root;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(curr.child[c-'a']==null) return false;
            curr=curr.child[c-'a'];
        }
        return curr.isEnd;
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        root=new Trie();
        for(String st:wordDict){
            insert(st); 
        }
        boolean[] dp=new boolean[s.length()+1];
        dp[0]=true;
        for(int i=1;i<=s.length();i++){
            for(int j=0;j<i;j++){
                if(dp[j]){
                    String sub=s.substring(j,i);
                    if(search(sub)){
                        dp[i]=true;
                        break;
                    }
                }
                
            }
        }
        return dp[dp.length-1];
    }
}
