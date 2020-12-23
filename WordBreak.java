/**
 * TC : O(n3) SC : O(n)
 * Approach : for each and every chars in the string if braking from that character can form a word from the dict, mark that index in the DP.
 *            if at the end index found the mark i.e last word is also in the dict, return true.
 */
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>();
        for(String word:wordDict){
            set.add(word);
        }
        
        int[] dp = new int[s.length()+1];
        dp[0] = 1;
        for(int i = 1; i <= dp.length; i++){
            for(int j = 0; j < i; j++){
                if(dp[j] == 1 && i < s.length() && set.contains(s.substring(j,i))){
                    dp[i] = 1;
                }else if(i == s.length()){
                    if(dp[j] == 1 && set.contains(s.substring(j))){
                        dp[i] = 1;
                    }
                }
            }
        }
        
        return dp[s.length()] == 1 ? true : false;
    }
}