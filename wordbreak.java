//TC : O(n^2)
//SC : O(n)

class Solution {
    Node root;
    class Node{
        boolean flag;
        Node[] children = new Node[26];
        public Node(){
            flag = false;
        }
    }

    public void insert(String word) {
        Node temp = root;
        for(int i=0;i<word.length();i++){
            char c = word.charAt(i);
            if(temp.children[c-'a'] == null){
                temp.children[c-'a'] = new Node();
            }
            temp = temp.children[c-'a'];
        }
        temp.flag = true;
    }
    
    public boolean search(String word) {
        Node temp = root;
        for(int i=0;i<word.length();i++){
            char c = word.charAt(i);
            if(temp.children[c-'a'] == null){
                return false;
            }
            temp = temp.children[c-'a'];
        }
        return temp.flag;
    }
    
    public boolean wordBreak(String s, List<String> wordDict) {
        root = new Node();
        for(String str:wordDict){
            insert(str);
        }
        //return helper(s,0);
        return helper2(s);
    }
    
    //bottom up dp
    private boolean helper2(String s){
        int n = s.length();
        boolean[] dp = new boolean[n+1];
        dp[0] = true;
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<i;j++){
                if(dp[j] && search(s.substring(j,i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
    
    //For loop base recursion
    public boolean helper(String s,int idx){
        int n = s.length();
        if(idx>n) return false;
        if(idx==n) return true;
        
        //logic
        boolean result=false;
        for(int i=idx;i<s.length();i++){
            String sub = s.substring(idx,i+1);
            if(search(sub)){
                result = helper(s,idx+sub.length());
                if(result)break;
            }
        }
        return result;
    }
}
