import java.util.List;

// Time Complexity :O(n^3)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : getting started

// Your code here along with comments explaining your approach
public class WordBreak {
    class Solution {
        public boolean wordBreak(String s, List<String> wordDict) {
            int n = s.length();

            //get the max lenght of the word in dict
            int maxLen = 0;
            for(String word:wordDict){
                maxLen = Math.max(maxLen, word.length());
            }

            //create dp array and set first value in array to true since there is always an empty sting in a dictionary
            boolean[] dp = new boolean[n+1];
            dp[0] = true;

            //loop from left to right and check if current dp is true and word dict contains the string by incrementing
            // the pointers and if found, update dp to be true and break
            for (int i = 0; i <= n; i++) {
                for (int j = 0; j < i ; j++) {
                    if(i - j > maxLen) continue;//optimization to break out when i-j is greate than the max length of dict
                    if(dp[j] && wordDict.contains(s.substring(j, i))){
                        dp[i] = true;
                        break;
                    }
                }
            }
            return dp[n];
        }
    }
}
