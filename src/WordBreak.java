// Create a dp array to check whether substring before the char at i can be split into valid strings or not
// and likewise do till the end of the string
// TC: O(n2)
// SC: O(n)
class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        for(int i=1;i<dp.length;i++) {
            int j = 0;
            while(j<i) {
                if(dp[j]) {
                String subString = s.substring(j,i);
                    if(wordDict.contains(subString)) {
                        dp[i] =  true;
                        break;
                    } else {
                        j++;
                    }
                } else{
                    j++;
                }
            }
        }
    return dp[s.length()];
    }
}