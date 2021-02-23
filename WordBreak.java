package DP-5;
// Time Complexity : O(n^3)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
public class WordBreak {
    class Solution {
        public boolean wordBreak(String s, List<String> wordDict) {
            HashSet<String> set = new HashSet<>(wordDict);
            return helper(s,set,0, new Boolean[s.length()]);
        }
        
        private boolean helper(String s , HashSet<String> wordSet, int index, Boolean [] memo)
        {
            
            if(index == s.length()) return true;
            
            if(memo[index] != null) return memo[index];
            
            for(int end = index+1;end<=s.length();end++)
            {
                if(wordSet.contains(s.substring(index,end)) && helper(s,wordSet,end,memo))
                {
                    return memo[index] = true;
                }
            }
            
            return memo[index] = false;
        }
    }
    
}
