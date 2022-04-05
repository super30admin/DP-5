// We can divide s into several subproblems.
// If the continuous subproblem are true then it means the bigger problem gives true
// Using this method we will go over the substrings and check
// The intermidiate results would be stored in array of booleans
// For the complete solution to be true the last index of array should be true


// Time Complexity : O(n^3)
// Space Complexity : O(n)

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int l = s.length();
        Set<String> hs = new HashSet<>(wordDict);
        boolean[] dp = new boolean[l+1];
        dp[0] = true;
        for(int i = 1; i <= l; i++){
            for(int j = 0; j < i; j++){
                if(dp[j] && hs.contains(s.substring(j,i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[l];
    }
} 
