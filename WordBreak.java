//TC = O(ml+n^3)
//SC = O(ml)
//Here we are using boolean dp array to track the word.
class WordBreak{
    HashSet<String> set;
    public boolean wordBreak(String s, List<String> wordDict) {
        this.set = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        for(int i = 1; i<dp.length; i++){
            for(int j = 0; j<i; j++){
                if(dp[j] && set.contains(s.substring(j,i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}