using System;
using System.Collections.Generic;
using System.Text;

namespace DP
{
    class WordMatchLC
    {
        //TC:
        //SC:
        public bool WordBreak(string s, List<string> wordDict)
        {
            if (wordDict.Count == 0 && s.Length != 0)
            {
                return false;
            }
            HashSet<string> set = new HashSet<string>(wordDict);
            return helper(s, set);
        }
        private bool helper(string s, HashSet<string> set)
        {
            //base
            if (s.Length == 0) return true;
            //logic
            for (int i = 1; i <= s.Length; i++)
            {
                if (set.Contains(s.Substring(0, i)) && helper(s.Substring(i), set))
                {
                    return true;
                }
            }
            return false;
        }
        //TC:O(n^2)
        //SC:O(n)
        public bool WordBreakOptmized(string s, List<string> wordDict)
        {
            if (wordDict.Count == 0 && s.Length != 0)
            {
                return false;
            }
            HashSet<string> set = new HashSet<string>(wordDict);
            int n = s.Length;
            bool[] dp = new bool[n + 1];
            dp[0] = true;
            for (int i = 1; i < n + 1; i++)
            {
                for (int j = 0; j < i; j++)
                {
                    if (dp[j])
                    {
                        if (set.Contains(s.Substring(j, i)))
                        {
                            dp[i] true;
                            break;
                        }
                    }
                }
            }
            return dp[n];
        }
    }
}
