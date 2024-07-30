//time O(Ln^2) where n is the size of string and L is the average length of substring//space O(mL) space of hashset

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>();
        for(String str: wordDict) {
            set.add(str);
        }
        int n = s.length();
        boolean[] dp = new boolean[n+1];
        dp[0] = true;
        for(int i = 1; i <= n; i++) {
            for(int j = 0; j < i; j++) {
                String sub = s.substring(j, i);
                if(set.contains(sub) && dp[j]== true) {
                    dp[i] = true;
                    break;
                } else {
                    
                    dp[i] = false;
                }
            }
        }
        return dp[n];
    }
}
