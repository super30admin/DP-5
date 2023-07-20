// Time Complexity : O(n^n)
// Space Complexity : O(nL)
// Did this code successfully run on Leetcode : NO (Time Limit Exceeded)

#include <iostream>
#include <vector>
#include <unordered_set>

using namespace std;

//exhaustive recursive
class Solution {
public:
    bool wordBreak(string s, vector<string>& wordDict) {
        unordered_set<string> set;
        for(auto it: wordDict){
            set.insert(it);
        }
        return helper(s, set);
    }
private:
    bool helper(string curr, unordered_set<string> set){
        //base
        if(curr.size() == 0) return true;
        //logic
        for(int i = 0; i < curr.size(); i++){
            string sub = curr.substr(0, i + 1);
            if(set.find(sub) != set.end() && helper(curr.substr(i + 1), set)){
                return true;
            }
        }
        return false;
    }
};