//Bruteforce
//time exponential
class Solution {
    HashSet<String> set;
    public boolean wordBreak(String s, List<String> wordDict) {
        set = new HashSet<>(wordDict);
        return helper(s);
    }
    
    private boolean helper(String s) {
        //base case
        if(s.length() == 0)
            return true;
        //logic
        for(int i=0; i<= s.length(); i++) {
            if(set.contains(s.substring(0,i)) && helper(s.substring(i))) {
                return true;
            }
        }
        return false;
    }
}


//Dp solution
//time o(n pow 4)
//space o(n)
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        //HashSet<String> set = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        for(int i=0; i<dp.length; i++) {
            for(int j=0; j<i; j++) { //with substring, checking the string in the list, overall time complexity o(n pow 4)
                if(dp[j] && wordDict.contains(s.substring(j,i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[dp.length-1];
    }
}