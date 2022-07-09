// Time Complexity : O(n ^ 4) 
// Space Complexity : O(w)
//          where w : number of words in the dictionary
// Did this code successfully run on Leetcode : yes

// Three line explanation of solution in plain english
/* Build DP array to store if string starting from 0th index till current index - 1 can be formed using dictionary.
 * Use pointer i to iterate over i/p string. i points to the current index and j starts from the 0th index.
 * Check if dp[j] is true and substring starting from j to index i - 1 is present in dictionary, 
 * if yes then set the dp[i] to true and increment i and reset j to 0. Return the last value of dp array.
 */

class Solution {
public:
    unordered_set<string> set;
    int n;
    bool wordBreak(string s, vector<string>& wordDict) {
        if (s.length() == 0 || wordDict.size() == 0)
            return false;
        
        n = s.length();
        for (auto& word : wordDict)
        {
            set.insert(word);    
        }
        
        bool dp[n + 1];
        for (auto& value : dp)
        {
            value = false;
        }
        
        dp[0] = true;
        
        for (int i = 1; i <= n; i++)
        {
            for (int j = 0; j < i; j++)
            {
                if (dp[j] == true)
                {
                    string sub = s.substr(j, i - j);
                    if (set.find(sub) != set.end())
                    {
                        dp[i] = true;
                        break;
                    }
                }
            }
        }
        
        return dp[n];
    }
    
};