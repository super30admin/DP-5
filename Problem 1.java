//Time Complexity: O(n ^ n) where n is the length of the string s
//Space Complexity: O(m) where m is the number of strings in wordDict due to HashSet

//Successfully runs on leetcode: Time limit exceeded

//Approach: For each substring of s, we will check if that substring is in wordDict as well as check if the remaining substring
//is also in wordDict using recursion. 

class Solution {
    HashSet<String> set;
    public boolean wordBreak(String s, List<String> wordDict) {
        if(s == null || s.length() == 0) return false;
        set = new HashSet<>(wordDict);
        return helper(s);
    }
    
    private boolean helper(String s)
    {
        //base
        if(s.length() == 0) return true;
        
        //logic
        for(int i = 0; i < s.length(); i++)
        {
            if(set.contains(s.substring(0,i+1)) && helper(s.substring(i+1)))
                return true;
        }
        return false;
    }
}


//Time Complexity: O(n ^ 3) where n is the length of the string s
//Space Complexity: O(m) where m is the number of strings in wordDict due to HashSet

//Successfully runs on leetcode: 6 ms

//Approach: As the same substrings are processed repeatedly using recursion, we can use DP to store the result of processing
//one substring and use it for later processing. We make a DP array and for each character in the string s, we check if the
//preceding string or character can be broken into valid partitions or not and reuse it for other substrings.


class Solution {
    HashSet<String> set;
    public boolean wordBreak(String s, List<String> wordDict) {
        if(s == null || s.length() == 0) return false;
        set = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        
        for(int i = 1; i < dp.length; i++)
        {
            for(int j = 0; j < i; j++)
            {
                if(dp[j] && set.contains(s.substring(j,i)))
                {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[dp.length - 1];
    }
}