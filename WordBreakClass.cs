// TC = O(n^2)
// SC = O(n)

public class Solution
{
    public bool WordBreak(string s, IList<string> wordDict)
    {
        if (string.IsNullOrEmpty(s) || wordDict == null || wordDict.Count == 0)
        {
            return false;
        }
        bool[] dp = new bool[s.Length + 1];
        dp[0] = true;
        HashSet<string> hashset = new HashSet<string>(wordDict);
        for (int i = 0; i <= s.Length; i++)
        {
            for (int j = 0; j < i; j++)
            {
                if (dp[j] && hashset.Contains(s.Substring(j, i - j)))
                {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.Length];
    }
}