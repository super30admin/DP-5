//Time  - O(n^2) where n is the length of the string
//Space - O(n)  
// Leetcode - worked

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        int n = s.length();
        if(s == null ||  n==0) return true;
        boolean [] dp = new boolean [n+1];
        dp[0] = true;
        for(int i =0;i<=n;i++){
            for(int j =0;j<i;j++){
                if(dp[j] && set.contains(s.substring(j,i))){
                    dp[i] = true;
                    break;
                }
            }
            System.out.println(dp[i]) ;
        }
        
        return dp[dp.length-1];
        
    }
}