/**
 * @Time complexity:
 * O(n^3) where n is the length of the string.
 * We have two nested for loops and to get the
 * substring we have to iterate again
 * 
 */

/**
 * @Space complexity:
 * The space complexity is O(1)
 * 
 */

/**
 * @Approach:
 * Dynamic Programming:
 * If we go for exhaustive approach, we will see repeated subproblems.
 * These are used to make a DP solution.
 * 
 * We are maintaing two pointers. We assume that the string before
 * the first char of the given string is valid. Now we move our pointer
 * to second char, we check the string between two pointers if it is in
 * set or not. If it is a valid string then we mark it as 1 or true in
 * our dp array. Otherwise we mark it as 0 or false. Now we move further
 * by moving our pointer. And these true and false guide us that strings 
 * before it will be valid or not. These are the substrings which can
 * be further split if they were not present in the set. So, in short
 * the dp array is reducing our calculations and helping in making
 * a dp solution.
 * 
 * 
 */

//The code ran perfectly on leetcode

class Solution {
public:
    bool wordBreak(string s, vector<string>& wordDict) {
        set<string> st;
        for(auto x : wordDict){
            st.insert(x);
        }
        vector<bool> dp(s.size() +1);
        dp[0] = true;
        for(int i =1; i<dp.size(); i++){
            for(int j =0; j<= i; j++){
                string c = s.substr(j,i-j);
                if(dp[j] && st.find(c) != st.end()){
                    dp[i] = true;
                    break;
                }
            } 
        }
        return dp[s.size()];   
    }
};