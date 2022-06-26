TC = Exponential

class Solution {
public:
    unordered_set<string> hashset;
    bool wordBreak(string s, vector<string>& wordDict) {
        for(auto word:wordDict)
            hashset.insert(word);
        return dfs(s);   
    }
    
    bool dfs(string s){
        //base
        if(s.length()==0) return true;
        //logic
        for(int i=0;i<s.length();i++){
            string x = s.substr(0,i+1);
            if(hashset.find(x)!=hashset.end() && dfs(s.substr(i+1))) return true;
        }
        return false;
    }
};
