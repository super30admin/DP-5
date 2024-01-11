//tc:O(n3)
//sc:O(n)

class Solution {
    unordered_set<string> set;
    unordered_map<string, bool> map;
public:
    bool wordBreak(string s, vector<string>& wordDict) {
        int n = s.size();
        for(auto it : wordDict){
            set.insert(it);
        }
      return helper(s);  
    }

private:
    bool helper(string s)
    {
        if(s.length() == 0) return true;

        if(map.find(s)!=map.end())     return map[s];

        for(int i = 0; i<s.length();i++)
        {
            string sub = s.substr(0,i+1);
            if(set.contains(sub) && helper(s.substr(i+1)))
            {
                    return map[s] = true;
            }
        }

        return map[s] = false;
    }
};