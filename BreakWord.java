//O(n^2 * substring length)
//SC: O(n+1)

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        Set<String> set = new HashSet<>(wordDict);
        for(int i=1;i<=s.length();i++)
        {
            for(int j=0;j<i;j++)    //Converting wordDic to set. Traversing through the element of string given by square time and checking if the element till that character substring is available in 
            {
                String str = s.substring(j,i);
                if(dp[j] && set.contains(str))
                {
                    dp[i] = true;
                    break;
                }
            }
        }
        
        return dp[dp.length-1];
    }
}