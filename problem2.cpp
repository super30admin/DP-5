/*
// Time Complexity : 2^(m*n)
// Space Complexity : O(m+n-1)
// Did this code successfully run on Leetcode : Yes
Time limit exceeded
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
*/

//brute force


#include<iostream>
#include<vector>

using namespace std;

class Solution {
    int cnt{};

    void helper(int m_pos,int n_pos, int m,int n){
        //base case
        if(m_pos == m-1 && n_pos == n - 1){
            cnt++;
            return;
        }
        //logic
        //go down check if down available
        if(m_pos<m-1) {
            helper(m_pos+1,n_pos,m,n);
        }
        //go right check if right available
        if(n_pos<n-1){
            helper(m_pos,n_pos+1,m,n);
        }
    }

public:
    int uniquePaths(int m, int n) {
        helper(0,0,m,n);
        return cnt;
    }
};

//using tabulation method 
/*
Time Complexity: O(m*n);
Space Complexity: O(n);

Succesfully run on leetcode: yes

Approach
Use the sum of previous paths and propogate that sum;
*/

class Solution {
public:

    int uniquePaths(int m, int n) {
        if(m == 1 || n == 1) return 1;
        vector<int> sol(n,1);
        for(int j{1};j<m;++j){
            for(int i{1};i<n;++i){
                sol.at(i) = sol.at(i) + sol.at(i-1);
            }
        }
        return sol.at(n-1);
    }
};