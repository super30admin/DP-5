// Brute Force
// Time Complexity : O(n)
// Space Complexity : O(n)

class Solution {
    HashSet<String> set;
    
    public boolean wordBreak(String s, List<String> wordDict) {
        set = new HashSet<>(wordDict);
        return helper(s);
    }
    
    private boolean helper(String s){
        if(s.length() == 0)
            return true;
        
        for(int i=0; i<=s.length(); i++){
            String prefix = s.substring(0, i);
            String sufix = s.substring(i);
            
            if(set.contains(prefix) && helper(sufix))
                return true;
        }
        
        return false;
    }
}


// DP Solution
// Time Complexity : O(n^2) not considering the time to calculate hash of string which will be l = average len of string
// Space Complexity : O(n)

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s.length() == 0) return true;
        
        boolean[] dp = new boolean[s.length()+1];
        HashSet<String> set = new HashSet<>(wordDict);         
        dp[0] = true;
        
        for(int i=1; i<dp.length; i++){
            for(int j=0; j<i; j++){
                if(dp[j] && set.contains(s.substring(j, i)))
                    dp[i] = true;
            }        
        }
        
        return dp[dp.length-1];
    }
}