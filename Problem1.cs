// Time Complexity : O(n^2)
// Space Complexity : O(n) for the dp array
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

/*
I create a hashset consisting of all the strings in wordDict. I create a boolean dp array of size n+1 and set the value of the 0th element to true, the true value here denotes that whatever substring is formed prior to the 0th index 
(empty string) is present in the hashset and is a valid substring. I then traverse from i = 1 to s.Length, and create substrings from j = 0 to i-1. If any of the
substrings are present in the hashset, I set dp[i] = true. If dp[j] is false, I simply proceed to the next iteration as it means that nonde of the possible substrings from that position
are present in the hashset and it's guaranteed to not return an answer. At the end I return dp[s.Length].

*/

public class Solution
{
    public bool WordBreak(string s, IList<string> wordDict)
    {
        bool[] dp = new bool[s.Length + 1];
        dp[0] = true;
        HashSet<string> set = new(wordDict);

        for (int i = 1; i <= s.Length; i++)
        {
            for (int j = 0; j < i; j++)
            {
                string subString = s.Substring(j, i - j);

                if (dp[j] && set.Contains(subString))
                {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[s.Length];

    }
}