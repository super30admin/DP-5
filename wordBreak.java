class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        
        int n=s.length();
        
        HashSet<String> set=new HashSet<>();
        
        for(String str : wordDict)
            set.add(str);
        
        boolean[] dp=new boolean[n+1];
        dp[0]=true;
        
        for(int i=1;i<n+1;i++)
        {
            for(int j=1;j<i+1;j++)
            {
                String str=s.substring(j-1,i);
                if(dp[j-1] && set.contains(str))
                        dp[i]=true;
            }
        }
        return dp[n];        
    }
}

// Time Complexity : O(N*N)
// Space Complexity : O(N+M)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
