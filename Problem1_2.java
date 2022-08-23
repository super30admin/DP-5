//Time Complexity: O(n^2); where n is the length of the string.
//Space Complexity: O(m) + O(n); where m is the size of wordDict.
//Code run successfully on LeetCode.

public class Problem1_2 {

    public boolean wordBreak(String s, List<String> wordDict)
    {
        
        if(wordDict == null|| wordDict.size() == 0)
            return false;
        
        else if(s == null|| s.length() == 0)
            return false;
        
        HashSet<String> set = new HashSet<>(wordDict);
        
        int n = s.length();
        
        boolean[] dp = new boolean[n+1];
        dp[0] = true;
        
        for(int i =1; i < s.length() +1; i++)
        {
            for(int j =0; j< i; j++)
            {
                if(dp[j] == true && set.contains(s.substring(j,i)))
                {
                    dp[i] = true;
                    break;
                }
            }
        }
        
        return dp[n];
    }
}
