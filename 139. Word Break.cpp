/*
Time: O(n*k*k) (k is the biggest length of word in dictionary)
Space: O(n)

Use DP
At every index we have the option to 1. continue building the substring, or 2. take this substring (if it exists in dictionary) and continue a new substring from next index
*/

class Solution {
public:
    unordered_map<string,bool> m;

    vector<int> dp;
    string s;
    int n;

    int max_len = 0;

    //dp states - st : starting index of current substring (all previous indices are guaranteed to be consumed)
    bool call(int st){
      if(st == n)  return true;
      if(dp[st] != -1)  return dp[st];

      string curr = "";
      bool possible = false;

      for(int i=st;i<n;i++){
        if(i-st > max_len)  break; //substring length crossed the biggest word in dictionary

        curr += s[i];
        if(m.count(curr))  possible = possible || call(i+1); //m.count(curr) is o(k) operation if curr's length is k

        if(possible)  return dp[st] = possible;
      }

      return dp[st] = false;
    }

    bool wordBreak(string s, vector<string>& words) {
        this->s = s;
        n = s.length();

        dp = vector(n, -1);
        
        for(auto word: words){
            max_len = max(max_len, (int)word.length());
            m[word] = true;
        }

        return call(0);
    }
};