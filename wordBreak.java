class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        if(s == null || s.length() == 0){
            return true;
        }
        
        boolean[] dp = new boolean[s.length() + 1];
        
        //create a hashset to  store wordDict
        HashSet<String> set = new HashSet<>(wordDict);
        
        //an empty string is true(base case)
        dp[0]=true;
        
        //looping through the string to validate 
        for(int i = 1; i < dp.length; i++){
            for(int j = 0; j < i; j++){
                if(dp[j] && set.contains(s.substring(j, i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[dp.length - 1];
    }
}

//Time complexity: O(n^3)
//Space Complexity: O(n)   n -> Max(set or string)