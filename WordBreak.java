/*
Time complexity - O(N^2)
Space Complexity - O(N)
*/
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        // dp[i] = true if the string till i can be partititioned into dictionary words.
        Set<String> set = new HashSet<>();
        for(String word : wordDict){
            set.add(word);
        }
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        for(int i=1;i<=s.length();i++){
            for(int j=0;j<i;j++){
                if(dp[j] && set.contains(s.substring(j,i))){
                    dp[i] = true;
                }
            }
        }
        return dp[s.length()];  
    }
}