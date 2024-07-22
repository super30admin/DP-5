// Problem 1
//TC O(n*n)
//SC O(n)
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
     if(s==null|| s.length()==0)
     {
        return true;
     }  
     int n=s.length();
     boolean dp[]= new boolean[n+1];
     HashSet<String> set= new HashSet<>(wordDict);
     dp[0]=true;
     for(int i=1;i<n+1;i++)
     {
        for(int j=0;j<i;j++)
        {
            if(dp[j]==true)
            {
                if(set.contains(s.substring(j,i)))
                {
                    dp[i]=true;
                    break;
                }
            }
        }
     }
     return dp[n];
    }
}

// Problem 2
//TC O(n*n)
//SC O(n)

class Solution {
    public int uniquePaths(int m, int n) {
      if(m==0|| n==0) return 0;
      int dp[]=new int[n];
      Arrays.fill(dp,1);
      for(int i=m-2;i>=0;i--)
      {
        for(int j=n-2;j>=0;j--)
        {
            dp[j]=dp[j]+dp[j+1];
        }
      }
      return dp[0];
    }
}