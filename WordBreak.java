// Approach 1 - DP
// Time complexity - O(n^2)
// Space complexity - O(n^2)
// Tested in leetcode

class WordBreak {
    // Use an array to solve the subproblem
    // For every substring(0,i), if it is valid word then store the result and use it as a subproblem to solve (i,len)
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>();
        for(String temp : wordDict)
            set.add(temp);
        // array to store intermediate result
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        
        // run two for loop, first for loop partition the given string (0,i) (i,len)
        // second for loop will check valid words till (0,i),  if chars from (0,i) is valid
        // it means substring (0,i) is valid, set dp[i];
        for(int i=1; i<dp.length;i++){
            for(int j=0; j<i; j++){
                if(dp[j] && set.contains(s.substring(j,i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}

// Approach 1 - Recursive 
// Time complexity - O(n^n)
// Space complexity - O(n)
// Time limit E

class Solution {
    HashSet<String> set = new HashSet<>();
    public boolean wordBreak(String s, List<String> wordDict) {
        for(String temp : wordDict)
            set.add(temp);
        return helper(s,0);
    }
    
    private boolean helper(String s, int index){
        // base case - return true if end of the string
        if(s.length() == index)
            return true;
        // paartition the given string 
        for(int i=index+1;i<=s.length();i++){
            // call the recursion for(i,len) only when (index,i) is a string of valid words
            if(set.contains(s.substring(index,i)) && helper(s,i))
                return true;
        }
        return false;
    }
}