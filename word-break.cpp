//Time - O(n^2)
//Space - O(n)
class Solution {
public:
    bool wordBreak(string s, vector<string>& wordDict) {
        vector<bool> dp (s.length()+1,false);
        unordered_set<string> uset;
        
        for(auto w:wordDict){
           uset.insert(w); 
        }
        if(uset.find(s)!=uset.end()) return true;
        
        dp[0] = true;
        for(int i=1;i<=s.length();i++){
            for(int j=1;j<=i;j++){
                string st = s.substr(j-1,i-j+1);
                if(dp[j-1] && uset.find(st)!=uset.end()){
                   dp[i] = true; 
                }
            }
        }
        
        
        return dp[s.length()];
    }
};