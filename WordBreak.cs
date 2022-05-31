
// Time Complexity : O(n^2)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

public bool WordBreak(string s, IList<string> wordDict) {
        
    if(s == null || s.Length == 0)
        return true;
    
    HashSet<string> set = new HashSet<string>(wordDict);
    
    //dp is length +1, because we always look for left substring , so we need to include th last character when checking for string
    bool[] dp = new bool[s.Length + 1];
        
    dp[0] = true;        
    
    for(int i = 1; i <= s.Length; i++)
    {
        for(int j = 0; j < i; j++)
        {
            //we look for substring only if current position at dp is true
            //that means word break of substring before that is found in set 
            if(dp[j])
            {
                //check string from j to i (not including ith character)
                string sub = s.Substring(j, i - j);
                //if substring is present, we mark dp at ith index to true, that means word break of 
                //string before ith index is present in set
                if(set.Contains(sub))
                    dp[i] = true;
            }
        }
    }
    return dp[s.Length];
}   