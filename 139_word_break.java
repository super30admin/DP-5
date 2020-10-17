    /*  Explanation
    # Leetcode problem link : https://leetcode.com/problems/word-break/
    Time Complexity for operators : o(n^3) .. n is the length of the string
    Extra Space Complexity for operators : o(max(n+m)) .. n for dp array and m for hashset
    Did this code successfully run on Leetcode : NA
    Any problem you faced while coding this : No
# Your code here along with comments explaining your approach
        # Basic approach : Two for loops and find the minimum window that has string. o(n*2) time complexity
        # Optimized approach: 
                              
            # 1. 
                    A) First create an dp array with the hashset. Haset will have the words from dictionary.
                    B) The first element of the dp will be laways true.
                    C) Then iterate over thee dp array starting from 1st. then check with rest of the string by
                       iterating through the j.
                    D) If at any point dp[j] is true and hashset contains  the substring the change the value of dp heree to true.
                    E) And the break, so come out of it.
                    F) At th end, return dp[dp.length-1].
    */ 

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        if(s.length() == 0 || s == null)
            return true;
        
        boolean dp[] = new boolean[s.length()+1];
        dp[0] = true;
        HashSet<String> hs = new HashSet<>(wordDict);
        
        for(int i=1;i<dp.length;i++){
            for(int j=0;j<i;j++){
                if(dp[j] && hs.contains(s.substring(j,i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        
        return dp[dp.length-1];
    }
}