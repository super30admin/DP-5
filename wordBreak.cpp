class Solution {
public:
    
    unordered_set<string> us;
    unordered_map<string,bool> um;
    bool flag=true;
    
    bool wordBreak(string s, vector<string>& wordDict) 
    {
        //cout<<"string is: "<<s<<endl;
        int i;
        
        if(s.length()==0)
            return true;
        
        if(um.find(s)!=um.end())
        {
            return um[s];
        }
        
        if(flag==true)
        {
            for(auto x:wordDict)
            {
                //cout<<"insert x: "<<x<<endl;
                us.insert(x);
            }
            flag=false;
        }
        
        for(i=1;i<=s.length();i++)
        {
           // cout<<i<<" ";
            if(us.find(s.substr(0,i))!=us.end() && wordBreak(s.substr(i,s.length()-i),wordDict))
            {
                um[s.substr(0,i)]=true;
                return true;
            }
        }
        
        um[s.substr(0,i)]=false;
        return false;
    }
};