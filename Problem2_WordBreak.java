// Time Complexity : o(n*n^4)
// Space Complexity : o(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    // BruthForce Approach
	//TC: O(N^N)
	//SC: O(N)
    public boolean wordBreak(String s, List<String> wordDict) {
       
        if(s==null||s.length()==0)
            return false;
        Set<String> set=new HashSet<>(wordDict);
        
        return helper(s,set);
    }
    
    private boolean helper(String s,Set<String> set)
    {
        if(s.length()==0)
            return true;
        
        for(int i=0;i<s.length();i++)
        {
            if(set.contains(s.substring(0,i+1)) && helper(s.substring(i+1),set))
                return true;
        }
        return false;
    }
    
    
    // DP Solution
  //TC: O(N*n^4)
  //SC: O(N)
    public boolean wordBreak(String s, List<String> wordDict) 
    {
        if(s == null || s.length() == 0)
            return false;
        
        //build a set
        Set<String> set = new HashSet<>(wordDict);
        int n = s.length();
        
        boolean[] dp=new boolean[n+1];
        
        dp[0]=true;
        
        for(int i=1;i<=n;i++)
        {
            for(int j=0;j<i;j++)
            {
                if(dp[j] && set.contains(s.substring(j,i)))
                {
                    dp[i]=true;
                    break;
                }
            }
        }
        return dp[n];
    }
}