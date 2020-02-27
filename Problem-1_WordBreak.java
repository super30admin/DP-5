// Time Complexity :
//      O(n*n) where n is the length of the string
//
// Space Complexity :
//      O(max(size of wordDict, size of s.length() +1))
//
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        //edge case
        if(s.length() == 0 || s == null)
            return false;
        //logic
        //create a hashset which stores all the words of dictionary
        HashSet<String> dict = new HashSet<>(wordDict);
        //create an array of size string length +1 to store true for indices where
        //we get a word that is contained in dictionary
        int[] dp = new int[s.length()+1];
        dp[0] = 1;
        for(int i=1;i<s.length() + 1; i++)
        {
            for(int j=0;j<i;j++)
            {
                if(dp[j] == 1 && dict.contains(s.substring(j,i)))
                {
                    dp[i] = 1;
                    break;
                }
            }
        }
        return dp[s.length()] == 1;
    }
}