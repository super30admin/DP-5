class Solution {
    HashSet<String> set;
    public boolean wordBreak(String s, List<String> wordDict) {
        if(s == null || s.length() == 0) {
            return true;
        }
        // Resursion solution
        // set = new HashSet<>(wordDict);
        // return recurse(s);

        // DP solution
        set = new HashSet<>(wordDict);
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for(int i = 1; i < n + 1; i++) {
            for(int j = 0; j < i; j++) {
                if(dp[j] == true) {
                    if(set.contains(s.substring(j, i))) {
                        dp[i] = true;
                        break;
                    }
                }
            }
        }
        return dp[n];
    }

    private boolean recurse(String s) {
        // base
        if(s.length() == 0) {
            return true;
        }

        // logic
        for(int i = 0; i < s.length(); i++) {
            if(set.contains(s.substring(0, i + 1)) && recurse(s.substring(i + 1))) {
                return true;
            }
        }
        return false;
    }
}
