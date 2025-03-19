//optimal (bottom up dp)
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
    HashSet<String> set = new HashSet<>(wordDict);
    int n= s.length();
    boolean [] dp = new boolean[n+1];
    dp[0]=true;
    for(int i=0;i<dp.length;i++)
    {
       
        for(int j=0;j<i;j++)
        {
            if(dp[j] && set.contains(s.substring(j,i)))
            {
                dp[i] = true;
                break;
            }
        }
        
    }
    return dp[n];
        }
}

//tc: O(n ^ 2)
//sc: O(n + m) n is the length of the dp array, m is the size of the hash set
