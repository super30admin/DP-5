/**
 * Brute FOrce - Exponential
 * Algo: #Check each substring and if that is there in the hashset then check for the other substring
 * Time: Exponential
 * Space:O(n) recursive stack - n length of the string
 */
class Solution {
    HashSet<String> hset;
    public boolean wordBreak(String s, List<String> wordDict) {
        hset = new HashSet<>(wordDict);
        return helper(s);
    }
    private boolean helper(String s){
        //base
        if(s.length() == 0) return true;

        //logic
        for(int i=0;i<=s.length();i++){
            if(hset.contains(s.substring(0,i)) && helper(s.substring(i))) return true;
        }
        return false;
    }
}

/**
 * Algo: #use the dp array to store if the substing is already checked
 *      #traverse thr the entire string and for each letter check if there is any combination that makes the string valid
 *
 *      Time: O(n^2) n- length of the string
 *      Space:O(n)
 */
class Solution {
    HashSet<String> hset;
    public boolean wordBreak(String s, List<String> wordDict) {
        hset = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;

        for(int i=0;i<=s.length();i++){
            for(int j=0;j<=i;j++){
                if(dp[j] && hset.contains(s.substring(j,i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[dp.length-1];
    }
}