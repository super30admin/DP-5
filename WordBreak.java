/** Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words. 
* TC O(n^3). There are two nested loops, and substring computation at each iteration. Overall that results in O(n^3) time complexity. 
* SC O(N)
*/
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        
        if (s == null || s.length() == 0) {
            return true;
        }
        boolean [] dp = new boolean[s.length() + 1];
        HashSet<String> dict = new HashSet<>(wordDict);
        dp[0] = true;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < i; j ++) {
                if (dp[j] && dict.contains(s.substring(j,i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[dp.length -1];
    }
}
