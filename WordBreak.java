// Time Complexity : 0(n^3) as there are 2 for loops and further there is substring of s
// Space Complexity : 0(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Was not able to think of dp approach

class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {

        if(s == null || s.length() == 0)
            return false;
        //dp array of s.length() + 1
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;

        //going across dp array
        for(int i=0;i<dp.length;i++){
            //checking each substring from 0 to i
            for(int j=0;j<i;j++){
                //if dp of substring is true and the next substring is also present in list
                if(dp[j] && wordDict.contains(s.substring(j,i))){
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[dp.length - 1];
    }
}