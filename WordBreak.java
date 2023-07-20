// Used HashSet to make search O(1)
// TC = O(nl+l^3) where l is the length of the word and l^3 term doesn't matter a lot
// l^2 for the 2 for loops and another l for finding substring each time
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        for(int i=1;i<s.length()+1;i++){
            for(int j=0;j<i;j++){
                if(dp[j]==true && set.contains(s.substring(j,i))){
                    dp[i] = true;
                }
            }
        }
        return dp[s.length()];
    }
}