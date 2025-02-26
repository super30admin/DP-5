/*
Time Complexity: O(n^2) - We check all possible substrings in a nested loop.
Space Complexity: O(n) - The DP array stores results for each substring length.
*/

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        if(s.length() == 0 || wordDict.size() == 0) {
            return true;
        }

        HashSet<String> set = new HashSet(wordDict);
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;

        for(int i = 1; i < n + 1; i++) {
            for(int j = 0; j < i; j++){
                if(dp[j] == true) {
                    if(set.contains(s.substring(j,i))){
                        dp[i] = true;
                        break;
                    }
                }
            }
        }
        return dp[n];
    }
}