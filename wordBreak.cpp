/*
We use the dp array for first partition and check if the current substring is in the dictionary.
If the word is in the dictionary, we process the remaining array.
//////////////////////////////////////////////////////////
Time Complexity: O(N^3), N^2 for the loop, N for getting the substring
Space Complexity: O(N)
//////////////////////////////////////////////////////////
*/

class Solution {
public:
    bool wordBreak(string s, vector<string>& wordDict) {
        vector<bool> dp(s.size()+1, false);
        dp[0] = true;
        for (int i=1; i<s.size()+1; i++)
            for (int j=0; j<i; j++)
                if ((dp[j]) && (std::find(wordDict.begin(), wordDict.end(), s.substr(j, i-j)) != wordDict.end())) {
                    dp[i] = true;
                    break;
                }
        return dp.back();
    }
};