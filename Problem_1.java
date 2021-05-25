//Time Complexity:O(n^3)
//Space Complexity:O(n+k) n is the length of s and k is length of word dict
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        if(s==null || s.length()==0) return false;
        HashSet<String> set =new HashSet<>(wordDict);
        boolean[] dp= new boolean[s.length()+1];
        dp[0] =true;
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<i;j++){
                if(dp[j] && set.contains(s.substring(j,i))){
                    dp[i]=true;
                    break;
                }
            }
        }
        return dp[dp.length-1];
    }
}