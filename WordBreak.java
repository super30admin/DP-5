/*
  Time: O(n^3)
  Spcae: O(n)
  Run on LeetCode: Yes
*/
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int []dp = new int[s.length() +1];
        HashSet<String> hs = new HashSet<>();
        hs.addAll(wordDict);

        dp[0] = 1;
        for(int j = 0; j < dp.length; j++){
            int i = 0;
            while(i < j){
                if(dp[i] == 1 && hs.contains(s.substring(i,j))){
                    dp[j] = 1;
                    break;
                }
                i++;
            }
        }
        
        return dp[dp.length -1] == 1;
    }
}
