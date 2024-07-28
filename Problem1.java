/*
    LC - 139. Word Break
    TC - O(n^3)
    SC - O(n + k) where k is the no. of word
    Approach -
        Using hashset for lookup
        keep the zero index as 1. and traverse through the string from 0. and j starts from zero to i 
        check dp[j] is true then only
        take the substring from j to i and check if it exists in set, then mark dp[i] as true and break this loop

        return dp[n]
*/

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        if(s == null || s.length() == 0) {
            return true;
        }
        HashSet<String> set = new HashSet<>(wordDict);
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for(int i=1; i<=n; i++) {
            for(int j=0; j<i; j++) {
                if(dp[j] == true) {
                    if(set.contains(s.substring(j, i))) {
                        dp[i] = true;
                        break;
                    }
                }
            }
        }
        return dp[n];
    }
}

/*
    LC - 139. Word Break
    TC - Exponential
    Approach -
        for loop recursion, check for substring. if it exist in hashset, then check for further indexed substring till length of string
        return true
        else false

*/

class Solution {
    HashSet<String> set;
    public boolean wordBreak(String s, List<String> wordDict) {
        if(s == null || s.length() == 0) {
            return true;
        }
        set = new HashSet<>(wordDict);
        return recurse(s);
    }
    private boolean recurse(String s) {
        // base
        if(s.length() == 0) {
            return true;
        }

        // logic
        for(int i=0; i<s.length(); i++) {
            if(set.contains(s.substring(0, i+1)) && recurse(s.substring(i+1))) {
                return true;
            } 
        }

        return false;
    }
}