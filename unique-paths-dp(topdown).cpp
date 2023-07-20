// Time Complexity : O(m x n)
// Space Complexity : O(m x n)
// Did this code successfully run on Leetcode : yes

#include <iostream>
#include <vector>

using namespace std;

//top-down dp
class Solution {
    vector<vector<int>> memo;
public:
    int uniquePaths(int m, int n) {
        this->memo = vector<vector<int>>(m, vector<int>(n, 0));
        return helper(m, n, 0, 0);
    }
private:
    int helper(int m, int n, int i, int j){
        //base
        if(i == m || j == n) return 0;
        if(i == m - 1 || j == n - 1) return 1;
        //logic
        //right
        int case1;
        if(j < n-1){
            if(memo[i][j+1] == 0){
                memo[i][j+1] = helper(m, n, i, j+1);
            }
            case1 = memo[i][j+1];
        }
        
        //left
        int case2;
        if(i < m-1){
            if(memo[i+1][j] == 0){
                memo[i+1][j] = helper(m, n, i+1, j);
            }
            case2 = memo[i+1][j];
        }
        return case1 + case2;
    }
};