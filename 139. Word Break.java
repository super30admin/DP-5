class Solution {//time of O(n^3) space of O(n)
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet(wordDict);
        
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        
        //finding if string is valid until i starting from 0
        for(int i=1 ; i<= s.length() ; i++){
            //Define start point of prefix
            for(int j = 0 ; j < i; j++){
                if(dp[j] && wordDictSet.contains(s.substring(j,i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}