//Time complexity is O(M) M is length of s
//Space complexity is O(M) M is length of s
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int[] memo = new int[s.length()];
        for(int i=0;i<s.length();i++){
            memo[i]=-1;
        }
        return helper(s, memo, wordDict, 0)==1?true:false;
    }
    public int helper(String s, int[] memo, List<String> words, int curr){
        if(curr==s.length()){
            return 1;
        }
        if(memo[curr]!=-1){
            return memo[curr]==0?0:1;
        }
        for(int i=curr+1;i<=s.length();i++){
            String sub = s.substring(curr, i);
            if(words.contains(sub) && helper(s, memo, words, i)==1){
                memo[curr]=1;
            }
        }
        if(memo[curr]!=1){
            memo[curr]=0;
        }
        return memo[curr];
    }
}
