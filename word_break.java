//Time Complexity: O(n^3)
//Space Complexity: O(N Word Dict) i.e number of words
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> seta = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for(int i=1; i<=s.length(); i++){
            for(int j = 0; j<i; j++){
                if(dp[j] && seta.contains(s.substring(j, i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}