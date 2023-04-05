// Time Complexity : O(n^n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
/* We are exploring all the path that are possible by doing the for loop resursion.
 * iterate through the string s and create a substring of s and check if that string is present in the set and the remaining string is sent 
 */  
class Solution {

    HashSet<String> set;
    public boolean wordBreak(String s, List<String> wordDict) {
        
        set = new HashSet<>(wordDict);

        return helper(s);
    }

    private boolean helper(String s)
    {
        //base
        if(s.length() == 0 )
            return true;

        //logic
        for(int i = 0 ;i < s.length(); i++)
        {
            String sub = s.substring(0, i+1);
            if(set.contains(sub) && helper(s.substring(i+1)))
            {
                return true;
            }
        }

        return false;
    }
}




// Time Complexity : O(n^2)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
/* create a boolean array which contains the true if the previous characters form a word present in the dictionary.
 * we have j variable which checks the previous word in the dictionary and if the word has boolean value in the array
 */  
class Solution {

    
    public boolean wordBreak(String s, List<String> wordDict) {
        
        HashSet<String> set = new HashSet<>(wordDict);

        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;

        for(int i = 1; i < dp.length; i++)
        {
            for(int j = 0 ; j < i; j++)
            {
                if(dp[j] && set.contains(s.substring(j,i)))
                {
                    dp[i] = true;
                }
            }
        }

        return dp[dp.length - 1];
    }

    
}