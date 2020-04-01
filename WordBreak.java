//TimeComplexity: O(n2)
//SpaceComplexity: O(n2)

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        s = "_"+s;
        Set<String> set =new HashSet(wordDict);
        
        boolean[] dp = new boolean[s.length()];
        
        dp[0] = true;
        
        for (int i = 1; i < s.length(); i++) {
            for (int j = i; j >= 1; j--) {
                
                if (dp[j-1] && set.contains(s.substring(j, i+1))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
