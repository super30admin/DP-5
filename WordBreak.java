class Solution 
{
    public boolean wordBreak(String s, List<String> wordDict) 
    {
        int inputLength = s.length();
        Set<String> set = new HashSet<>(wordDict);
        boolean dp[][] = new boolean[inputLength+1][inputLength+1];
        
        for(int partitionSize = 1; partitionSize <= inputLength; partitionSize++)
        {
            for(int index = 0; index + partitionSize <= inputLength; index++)
            {
                String input = s.substring(index, index + partitionSize);
                
                int start = index;
                int end = index + partitionSize -1;
                
                if(set.contains(input))
                {
                    dp[start][end] = true;
                }
                else
                {
                    int length = input.length();
                    for(int partition = 1; partition < length; partition++)
                    {
                        boolean prefix = dp[start][start+partition-1];
                        boolean suffix = dp[start+partition][end];
                        
                        boolean result = prefix && suffix;
                        
                        if(result)
                        {
                            dp[start][end] = true;
                            break;
                        }
                    }
                }
            }
        }
        
        return dp[0][inputLength-1];
        
    }
}