//time complexity : O(n^3) n is length of input string
//space complexity : O(n) + O(m) //m is length of dict

class Solution {

    //code 2 - DP

    public boolean wordBreak(String s, List<String> wordDict) {

        boolean[] dp = new boolean[s.length()+1];
        HashSet<String> set = new HashSet(wordDict);

        dp[0] = true;
        
        for(int i=0; i<dp.length; i++)
        {
            for(int j=0; j<i; j++)
            {
                if(dp[j] && set.contains(s.substring(j,i)))
                {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[s.length()];
    }
}
