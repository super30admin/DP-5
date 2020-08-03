// Time Complexity : O(n^2)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int[] dp = new int[s.length()+1];
        int n = s.length();
        dp[0]=1;
        for(int i=1;i<n+1;i++){
            int j=0;
            while(j<i)
                {
                if(dp[j]==1 && wordDict.contains(s.substring(j,i)))
                {
                    dp[i]=1;
                    break;
                }
                j++;
            }
            }
        
        return dp[n]==1;
        }
    }
