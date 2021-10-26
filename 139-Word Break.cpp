/*
TC = Exponential
SC = Exponential
Time limit exceeded
*/
class Solution {
public:
    bool helper(string s,set<string> st)
    {
        //base
        if(s.length()==0)
            return true;
        //logic
        for(int i=1;i<=s.length();i++)
        {
            if(st.find(s.substr(0,i))!=st.end() && helper(s.substr(i),st))
                return true;
        }
        return false;
    }
    bool wordBreak(string s, vector<string>& wordDict) {
        if(s.length()!=0 && wordDict.size()==0)
            return false;
        if(s.length()==0)
            return true;
        set<string> st;
        int i;
        for(i=0;i<wordDict.size();i++)
            st.insert(wordDict[i]);
        return helper(s,st);
    }
};

/*
TC = O(n^4)
SC = O(l)
Where l is the length of the string.
Time limit exceeded
*/
class Solution {
public:
    bool wordBreak(string s, vector<string>& wordDict) {
        if(s.length()!=0 && wordDict.size()==0)
            return false;
        set<string> st;
        int i,j;
        for(i=0;i<wordDict.size();i++)
            st.insert(wordDict[i]);
        int n=s.length();
        vector<bool> dp(n+1,false);
        dp[0]=true;
        for(i=1;i<n+1;i++)
        {
            for(j=0;j<i;j++)
            {
                if(dp[j])
                {
                    if(st.find(s.substr(j,i-j))!=st.end())
                    {
                        dp[i]=true;
                        break;
                    }
                }
            }
        }
        return dp[n];
    }
};
