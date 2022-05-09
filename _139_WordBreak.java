// Time Complexity :n^2 where n is size of String
// Space Complexity : n
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
// partition at each index and check if substring is present in dictoinary and call recursion function on remaining string
class Solution {

    Set<String> dict;

    public boolean wordBreak(String s, List<String> wordDict) {
        dict = new HashSet<>(wordDict);
        int[] dp = new int[s.length()];
        return helper(s,0,dp)==1;
    }

    public int helper(String s, int index, int[] dp){

        if(s.length() == index) return 1;
        if(dp[index] != 0) return dp[index];

        dp[index] = -1;

        for(int i = index ; i< s.length(); i++){
            String partition = s.substring(index, i+1);
            if(dict.contains(partition)){
                if(dp[index] == -1){
                    dp[index] = helper(s, i+1, dp);
                }
            }
        }
        return dp[index] ;
    }
}

//Bottom -up
class Solution {

    Set<String> dict;

    public boolean wordBreak(String s, List<String> wordDict) {
        dict = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length()];

        for(int i = 0 ; i< s.length(); i++){
            for(int j = i ; j>=0; j--){
                String partition = s.substring(i-j, i+1);
                if(dict.contains(partition) && !dp[i]) {
                    if(i-j == 0){
                        dp[i] = true;
                    }
                    else{
                        dp[i] = dp[i-j-1];
                    }
               }
            }
        }
        return dp[s.length()-1] ;
    }
}
