/* Time Complexity : O(n^n) 
 *  n - len. of string 's' */
/* Space Complexity : O(n)
 * DP array */

//DP

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        int n = s.length();
        //Initializing DP array to str len - 1 : last index gives the result
        boolean[] dp = new boolean[n + 1];
        //Set 0th idx as true
        dp[0] = true;
        //Iterate over the string, check if valid substring can be created using the str before curr idx by looking up in the set.
        //If str exists mark curr idx in dp as true 
        for(int i = 1; i <= n; i++){
            for(int j = 0; j < i; j++){
                if(dp[j] && set.contains(s.substring(j, i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
}
