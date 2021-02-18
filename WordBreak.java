// Time Complexity : O(n^3), two "for" loops and a substring function
// Space Complexity : O(n), n = length of the string
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Notes : Populate a DP array with true if any substring till that position is found in the dictionary with a valid partition, eg, in LEETCODE, if we are at O, and if LE is present in the dictionary, then value at O will be true only if ETC is present in the dictionary, indicating valid partitions.

public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        
        boolean[] dp = new boolean[s.length()+1] ;  
        
        dp[0] = true;
        
        for(int i = 1; i < dp.length; i++){
            for(int j = 0; j < i; j++){
                if(dp[j] && set.contains(s.substring(j, i))){
                    dp[i] = true;
                    break;
                }
                dp[i] = false;
            }
        }
        return dp[dp.length - 1];
    }
}
