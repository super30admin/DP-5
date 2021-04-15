//Make a hashset and map the Word dict to it.
//TC:O(n3) due to substring fn we get extra O(n)
//SC:O(n)
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> myHashSet = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        String t; 
        for(int i = 1; i<= s.length(); i++){
            for(int j = 0; j < i;j++){
                t = s.substring(j,i);
                if(dp[j] && wordDictSet.contains(t)){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}