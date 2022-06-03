//time - O(n^2)
//space - (m+n)
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {

        int n = s.length();

        HashSet<String> set = new HashSet<>(wordDict);

        boolean[] dp = new boolean[n+1];
        dp[0] = true;

        for(int i=1; i<=n; i++){
            for(int j=0; j<i; j++){
                String sub = s.substring(j, i);
                if(dp[j]){
                    if(set.contains(sub)){
                        dp[i] = true;
                    }
                }
            }
        }

        return dp[n];
    }
}
