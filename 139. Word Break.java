
// Time Complexity :O(n*n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    public boolean helper(HashSet<String> hs, String s, int i, int[] dp){
        if(i==s.length())return true;
        if(dp[i]!=0)return false;
        for(int k=i+1;k<=s.length();k++){
            if(hs.contains(s.substring(i,k)) && helper(hs,s,k,dp))return true;
        }
        dp[i]=1;
        return false;
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> hs=new HashSet<>();
        for(String w:wordDict){
            hs.add(w);
        }
        int[] dp=new int[s.length()];
        return helper(hs,s,0,dp);
    }
}