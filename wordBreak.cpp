//time complexity:O(n^3)
//space complexity:O(n)
//executed on leetcode: yes
//approach:using dp
//any issues faced? yes, had to see the solution

class Solution {
public:
    bool wordBreak(string s, vector<string>& wordDict) {
    
        set<string>set(wordDict.begin(),wordDict.end());
        vector<bool>dp(s.size()+1);
        dp[0]=true;
        for(int i=1; i<=s.size(); i++)
        {
            for(int j=0; j<i; j++)
            {
                if(dp[j] && set.find(s.substr(j,i-j))!=set.end())
                {
                    dp[i]=true;
                    break;
                }
            }
        }
        return dp[s.size()];
    }
};