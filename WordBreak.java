import java.util.List;

/*
## Problem 1: (https://leetcode.com/problems/word-break/)

Time Complexity :   O (n^3) 
Space Complexity :  O (n)
Did this code successfully run on Leetcode :    Yes (139. Word Break)
Any problem you faced while coding this :       No
 */
// Input: s = "leetcode", wordDict = ["leet","code"]
// Output: true

class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {        
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        
        for(int i=1; i<=s.length(); i++){
            for(int j=0; j<i; j++){
                if(dp[j] && wordDict.contains(s.substring(j,i))){
                    dp[i] = true;
                    break;
                }     
            }
        }
        return dp[s.length()];
    }
}