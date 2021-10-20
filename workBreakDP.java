// Time Complexity : O(n^2)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : None

public class workBreakDP {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<String>(wordDict.size());
        int minLen = Integer.MAX_VALUE;
        int maxLen = 0;
        for(String w: wordDict)
        {
            dict.add(w);
            minLen = w.length() < minLen ? w.length(): minLen;
            maxLen = w.length() > maxLen ? w.length() :maxLen;
        }

         boolean[] dp= new boolean[s.length() + 1];   
         dp[0] = true;
        //How to deal with (app,apple)
        //Flag end of each possible word as T
        for (int i = minLen; i <= s.length(); i++) {
            for (int j = i-maxLen >0? i-maxLen:0 ; j < i; j++) {
                if (dp[j] && dict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
