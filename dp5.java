//Problem1: (https://leetcode.com/problems/word-break/)
// Time Complexity : O(n^3)
// Space Complexity :O(n)+O(ml) m=length of dict, l=avg length of string, n=dp.length
// Did this code successfully run on Leetcode : yes

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set=new HashSet<>(wordDict);
        boolean dp[]=new boolean[s.length()+1];
        dp[0]=true;
        for(int i=1;i<s.length()+1;i++)
        {
            for(int j=0;j<i;j++)
            {
                if(set.contains(s.substring(j,i)) && dp[j])
                {
                    dp[i]=true;
                    break;
                }
            } 
        }
        return dp[s.length()];
    }
}


//Problem2: (https://leetcode.com/problems/unique-paths/)
// Time Complexity : O(mn)
// Space Complexity :O(mn)
// Did this code successfully run on Leetcode : yes


class Solution {
    public int uniquePaths(int m, int n) {
        int dp[][]=new int[m][n];
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                dp[i][j]=1;
            }   
        }
        for(int i=m-2;i>=0;i--) {
            for(int j=n-2;j>=0;j--) {
                dp[i][j]=dp[i+1][j]+dp[i][j+1];
            }   
        }
        return dp[0][0];     
    }
}




