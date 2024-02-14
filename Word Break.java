// Time Complexity : O(n * l + l ^ 2)
// Space Complexity : O(n * l)
// Method used : DP

class Solution {

    int[] dp;

    public boolean wordBreak(String s, List<String> wordDict) {
        
        dp = new int[s.length()];

        HashSet<String> set = new HashSet();

        for(String temp : wordDict) set.add(temp);

        return helper(0, set, s);
    }

    private boolean helper(int index, HashSet<String> set, String s)
    {
        // This means I could find the complete word as I crossed the array
        if(index == s.length()) return true;

        // We need to optimize only the path which we already evaluated as false. Because if answer is true any way
        // we are doing a conditional recursion so we won't have extra function calls there.
        if(dp[index] == 1) return false;

        for(int j = index; j < s.length(); j++)
        {
            // fetch the substring
            String temp = s.substring(index, j + 1);
            
            // Only perform recursion if the string is already present in the set
            if(set.contains(temp))
            {
                if(helper(j + 1, set, s) == true) return true;
            }
        }

        dp[index] = 1;
        return false;
    }
}