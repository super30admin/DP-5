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
