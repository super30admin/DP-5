// Time: O(N^3) | Space: O(No of words in Dict) + O(DP array length)
// DP soln

class Solution {

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                // checking every substring and updating the dp array if the substring is a part of dict
                if (dp[j] && dict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[dp.length - 1];
    }

}

// brute force - recursive solution
// Time: O(Exponential) | Space: O(Length of the string - recursive call stack)
class Solution {
    Set<String> dict;
    public boolean wordBreak(String s, List<String> wordDict) {
        dict = new HashSet<>(wordDict);
        return helper(s);
    }
    private boolean helper(String s) {
        if(s.length() == 0) return true;
        for(int i=0;i<s.length();i++) {
            // only if the substring is present in the dictionary, we are exploring further
            if(dict.contains(s.substring(0, i+1)) && helper(s.substring(i+1))) return true;
        }
        return false;
    }
}