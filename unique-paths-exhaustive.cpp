// Time Complexity : O(m^2 x n^2)
// Space Complexity : O(m^2 x n^2)
// Did this code successfully run on Leetcode : NO (Time Limit Exceeded)

#include <iostream>

using namespace std;

class Solution {
public:
    int uniquePaths(int m, int n) {
        return helper(m, n, 0, 0);
    }
private:
    int helper(int m, int n, int i, int j){
        //base
        if(i == m || j == n) return 0;
        if(i == m - 1 || j == n - 1) return 1;
        //logic
        //right
        int case1 = helper(m, n, i, j+1);
        //left
        int case2 = helper(m, n, i+1, j);
        return case1 + case2;
    }
};