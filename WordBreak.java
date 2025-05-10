//TC: O(2L * L2) = L3
//SC: O(N+1)


class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        int n = s.length();

        boolean[] dp = new boolean[n+1];
        dp[0] = true;

        for(int i=1; i<=n; i++) { //O(l)
            for(int j=0; j<i; j++) { //O(l)
                if(dp[j] && set.contains(s.substring(j,i))){ //O(2l) - set.contains is also O(l) as it has to generate a hash.
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
          
    }
}
