class Solution {
public:
    unordered_set<string>hashset;
    /*bool wordBreak(string s, vector<string>& wordDict) {
        for(auto i:wordDict)
            hashset.insert(i);
        return helper(s);
    }
    bool helper(string s)
    {
        if(s.size()==0)
            return true;
        for(int i=0;i<=s.size();i++)
        {
            if(hashset.count(s.substr(0,i)) && helper(s.substr(i)))
                return true;             
        }
        return false;
    }*/
    bool wordBreak(string s, vector<string>& wordDict) {        
        set<string>word_set(wordDict.begin(), wordDict.end());
        int len=s.size();
        vector<bool>dp(len + 1,false);
        dp[0]=true;
        for(int i=1;i<=len;++i)
        {
            for (int j=i-1;j>=0;++j)
            {
                if (dp[j]&&word_set.find(s.substr(j,i-j))!=word_set.end())
                {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[len];
    }
};