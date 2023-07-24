/*
// Time Complexity : O(n^2)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
Check wether the partition occurs before the the given string and the following substring is inside the dictionary
If yes then make for the following index the partition is true.
To check for the partition for a string of i length.
You check for each j wether the partition before that index is possible and the substring between j and i . 
For example : If string is leetcode  , words in the dictionary are "leet" and "code".
and if your initial string is leetc.
Then for j = 0 check if the partition before it is true. Its a base case as no string occurs so thats true. 
Then check substring i-j that is leet occurs. Since it occurs so move ahead.
If the string was leetco. that is i at 'o'.
When j is at c. Then we can see that leet occurs however the substring 'o' doesnt then false , moveahead . 
Since the string before is also not a parition move until j is less than  i and stop only if the substring found after the 
partition is true.
*/

#include<iostream>
#include<vector>
#include<string>

using namespace std;


typedef struct TrieNode{

    vector<TrieNode*> children = vector<TrieNode*> (26,NULL);
    bool flag{false};
}TrieNode;

class Trie{
    TrieNode* root = new TrieNode();
    public:
    void insert(string& s){
        TrieNode* curr{root};
        for(char& c:s){
            int idx = c - 'a';
            if(curr->children.at(idx) == NULL){
                curr->children.at(idx) = new TrieNode;
            }
            curr = curr->children.at(idx);
        }
        curr->flag = true;
    }
    bool find(string& s){
        TrieNode* curr{root};
        for(char&c :s){
            int idx = c - 'a';
            if(curr->children.at(idx)){
                curr = curr->children.at(idx);
            }
            else{
                return false;
            }
        }
        return curr->flag;
    } 
};


class Solution {
public:
    bool wordBreak(string s, vector<string>& wordDict) {
        Trie tree;
        for(string& s:wordDict){
            tree.insert(s);
            //cout<<tree.find(s);
        }
        size_t n = s.size();
        vector<bool> dp(n+1,false);
        dp.at(0) = true;
        for(int i{};i<=n;++i){
            for(int j{};j<i && dp.at(i) == false;++j){
                if(dp.at(j)){
                    string sub = s.substr(j,i-j);
                    if(tree.find(sub)){
                        dp.at(i) = true;
                    }
                }
                //cout<<i<<" "<<dp.at(i)<<endl;
            }
        }
        return dp.at(n);
    }
};