//Time Complexity: O(n^3)
//Space Complexity: O(n)

//DP solution:

class wordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> wordSet = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length()+1];

        //there's nothing before first element so empty string is considered to be valid spilt
        dp[0] = true;
        for(int i=1; i<dp.length; i++){
            for(int j=0; j<i; j++){
                //if dp[j] gives true, means string before it can be spit in to valid splits.
                // and we'll mark it true only if sub-string between j and i is valid spilt.
                if(dp[j] && wordSet.contains(s.substring(j,i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        //if the last element is true, means whole string can be split in to valid splits.
        return dp[dp.length-1];
    }
}