/*
TC : O(N^2)
SC : O (N)
*/
class Solution
{
public:
    bool wordBreak(string s, vector<string> &wordDict)
    {
        if (s.size() == 0 || s.empty())
        {
            return true;
        }

        set<string> store;
        for (auto i : wordDict)
        {
            store.insert(i);
        }

        vector<bool> dp(s.size() + 1, false);
        dp[0] = true;

        for (int i = 1; i < s.size() + 1; i++)
        {
            for (int j = 0; j < i; j++)
            {
                // check if the
                if (dp[j] == true)
                {
                    // check if the substring exists in the set
                    string t = s.substr(j, i - j);
                    if (store.find(t) != store.end())
                    {
                        dp[i] = true;
                        break;
                    }
                }
            }
        }

        return dp[s.size()];
    }
};