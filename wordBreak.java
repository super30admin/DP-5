class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        if(s.length() == 0 || s == null) return false;
        int n = s.length();
        boolean dp[] = new boolean [s.length() + 1];
        dp[0] = true;
        HashSet<String> set = new HashSet<>(wordDict);
        for(int i = 1; i < dp.length; i++){
            for(int j = 0; j < i; j++){
                String str = s.substring(j, i);
                if(dp[j] && set.contains(str)){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[dp.length - 1];
    }
}
