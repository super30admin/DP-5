// Time Complexity - O(n^2+m) n = string len; m = no of words in the dict 
// Space Complexity - O(n) n = str len
// Approach
// Take first cell of dp as true. As the i pointer moves, we take the substring from j to i and
// check if the substring is in the hashset and mark the ith position as true.
// If the dp[j] is true, substring is not in the set move the j pointer and create the substring to check 
// if the set contains the substring further.

// Brute Force
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        if(s==null) return false;
        HashSet<String> set = new HashSet<>(wordDict);
        return helper(s,set);
    }
    
    private boolean helper(String s, HashSet<String> set) {
        if(s.length()==0) return true;
        for(int i=0;i<=s.length();i++) {
            if(set.contains(s.substring(0,i)) && helper(s.substring(i),set)) return true;
        }
        return false;
    }
}

// Optimised using DP

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        if(s==null) return false;
        HashSet<String> set = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        for(int i = 1;i<dp.length;i++) {
            int j=0;
            while(j<i) {
                if(dp[j] && set.contains(s.substring(j,i))) {
                    dp[i] = true;
                    break;
                }
                j++;
            }
        }
        return dp[dp.length-1];
    }
}