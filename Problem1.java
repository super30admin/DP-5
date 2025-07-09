//Time Complexity: O(n^2)
//Space Complexity: O(n) for the 1D dp array
//Did this code successfully run on Leetcode: Yes
//Any problem you faced while coding this: No
//Three line explanation of solution in plain english:
// 1. We use dp to keep track of whether a substring can be segmented into words from the dictionary.
// 2. We iterate through the string and for each position, we check all previous positions to see if a valid word ends there.
// 3. If we find a valid segmentation, we mark the current position as reachable.

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        // Convert the wordDict to a HashSet
        HashSet<String> set=new HashSet<>(wordDict);
        // Create a boolean array to keep track of reachable positions
        // dp[i] will be true if the substring s[0:i] can be segmented
        boolean [] dp=new boolean[s.length()+1];
        // Initialize dp[0] to true, as an empty string can always be segmented
        dp[0]=true;
        // We check if the substring s[j:i] is in the dictionary for all j <= i
        for(int i=1;i<dp.length;i++){
            for(int j=0;j<i;j++){
                // If dp[j] is true and the substring s[j:i] is in the dictionary, mark dp[i] as true
                if(dp[j] && set.contains(s.substring(j,i))){
                dp[i]=true;
                }
            }
        }
        // The final result is whether the entire string can be segmented
        return dp[dp.length-1];
    }
}