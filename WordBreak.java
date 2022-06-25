
class Solution 
{
    public boolean wordBreak(String s, List<String> wordDict) 
    {
        
        int length = s.length();
        Set<String> set = new HashSet<>(wordDict);
        boolean dp[][] = new boolean[length][length];
        
        for(int i = 1; i <= length; i++)
        {
            for(int j = 0; j + i < length+1; j++)
            {
                String input = s.substring(j, j + i);
                
                if(set.contains(input))
                    dp[j][j+i-1] = true;
                else
                {
                    int start = j;
                    int end = j + i;
                    
                    for(int k =1; k < input.length(); k++)
                    {
                        
                        boolean firstHalf = dp[start][start+k-1];
                        boolean secondHalf = dp[start+k][end-1];
                        boolean result = firstHalf && secondHalf;
                        if(result)
                        {
                            dp[start][end-1] = result;
                            break;
                        }
                            
                    }
                }
            }
        }
        
        
        return dp[0][length-1];
        
    }
}