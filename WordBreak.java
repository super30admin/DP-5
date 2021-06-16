/*
Desc : Here we take a boolean array of size n+1 where the n is the size of the string s, we store true at beginning of every substring
that is present in the dict as well if. we iterate through the whole array and if we find a true in the last position of array we return true.
Time Complexity : O(n)
Space Complexity : O(n)
*/

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        if(s==null || s.length()==0) return false;
        HashSet<String> set = new HashSet<>(wordDict);
        boolean [] dp = new boolean[s.length()+1];
        dp[0] = true;
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<i;j++){
                if(dp[j] && set.contains(s.substring(j,i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[dp.length-1];
    }
}
