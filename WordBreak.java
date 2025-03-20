//Time Complexity O(n^2)
//Space Complexity O(n)
class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || s.length() == 0 || wordDict.size() == 0) {
            return false;
        }
        Set<String> set = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i=1; i < s.length() + 1; i++) {
            for(int j=0; j<=i; j++){
                String curr = s.substring(j, i);
                if(dp[j] && set.contains(curr)){
                    dp[i] = true;
                }
            }
        }

        return dp[s.length()];
    }
}
