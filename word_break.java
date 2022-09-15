
// Time Complexity : O(l*2) - l is lenth of the word
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english: Used Dynamic Programming using bottom-up approach, will have two pointers and mark each charater at true if a word is found and is breakable

// Your code here along with comments explaining your approach


class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        boolean [] dp=new boolean[s.length()+1];
        
        dp[0] =true;
        
        for (int i=1; i<dp.length; i++){
            for(int j=0; j<i; j++){
                if (dp[j] && set.contains(s.substring(j, i))){
                    dp[i] = true;
                    break;
                } 
            }
        }
        return dp[dp.length - 1];
        
    }
}