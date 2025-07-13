// Total Time Complexity = O(n^2)
// SC : O(K*M + N)
// K*M for set to store dictionary words
// N -- bool array size;

// Step 1: Preprocessing
// Store wordDict into an unordered_set for O(1) average lookups.
// This allows fast checks if a substring exists in the dictionary.
// Step 2: DP Table Definition
// Let dp[i] = true if s[0:i] can be segmented into dictionary words.
// Initialize dp[0] = true (empty string is segmentable).
// We fill dp[1...n] using the recurrence:
// For each i, check all j < i:
// If dp[j] == true and s[j:i] is in the dictionary:
// Then dp[i] = true and break inner loop.
// Step 3: Return the Result
// Return dp[n], indicating whether the entire string s can be segmented.

class Solution {
public:
    bool wordBreak(string s, vector<string>& wordDict) {
        unordered_set<string> set{wordDict.begin(), wordDict.end()};
        int n = s.length();
        bool * dp = new bool[n+1]();
        dp[0] = true;
        for(int i=1;i<=n;++i){
            for(int j =0; j<i;++j){
                if(dp[j] && set.find(s.substr(j,i-j)) != set.end()){
                    dp[i] = true;
                    break;
                }
            }
        }
        bool res = dp[n];
        delete []dp;
        return res;
    }
};
