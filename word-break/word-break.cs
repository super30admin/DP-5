public class Solution {
    public bool WordBreak(string s, IList<string> wordDict) {
        HashSet<String> dict = new HashSet<String>(wordDict);
        Dictionary<String,bool> d= new Dictionary<String,bool>();
        bool[] dp = new bool[s.Length+1];
        dp[0] = true;
        
        for(int i=1;i<=s.Length;i++)
        {
            for(int j=0;j<i;j++)
            {
                Console.WriteLine(i);
                Console.WriteLine(j);
                if(dp[j] && dict.Contains(s.Substring(j,i-j)))
                {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.Length];
        
    }
}
