// Problem - Word Break
//  Time Complexity : O(n^3)
//  Space Complexity : O(n) + O(n*k)
//  Did this code successfully run on Leetcode : Yes
//  Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// 1. We first add all our dictionary words to set
// 2. We initialize a boolean DP array, and set initial to true, since at each
// index, we say whether the string before the index can be partitioned ornot
// 3. if yes, and the substring with j and i -j also exists in the set, we say
// that prefix is possible
// 4. In the end, we have the answer at dp[s.size()]

#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
  bool wordBreak(string s, vector<string> &wordDict) {
    unordered_set<string> se(begin(wordDict), end(wordDict));
    vector<bool> dp(s.size() + 1, false);
    dp[0] = true;
    for (int i = 1; i <= s.size(); i++) {
      for (int j = 0; j < i; j++) {
        if (dp[j] && se.count(s.substr(j, i - j)) > 0) {
          dp[i] = true;
          break;
        }
      }
    }

    return dp[s.size()];
  }
};
