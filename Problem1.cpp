// Problem - Unique Paths
//  Time Complexity : O(n)
//  Space Complexity : O(mxn)
//  Did this code successfully run on Leetcode : Yes
//  Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// 1. Here we first declare a one dimensional array with values set to 1
// 2. We start our iteration from m-2 and n-2 since last row and last col values
// will always be 1 since there is only one way to go from there
// 3. We iterate and keep the updating the values of our dp, by adding current
// value + dp[j+1]
// 4. In the end, we return dp[0] since it will contain our answer

#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
  int uniquePaths(int m, int n) {
    vector<int> dp(n, 1);

    for (int i = m - 2; i >= 0; i--) {
      for (int j = n - 2; j >= 0; j--) {
        dp[j] = dp[j] + dp[j + 1];
      }
    }

    return dp[0];
  }
};
