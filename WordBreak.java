/*
 * Time complexity : O(n^2)
 * Space complexity : O(n)
 * 
 * Approach : At every character of string, the substring from slow to current-1 index is checked in hashset. If its present in given set, value of dp element is set to true.
 * 			Slow pointer is incremented untill its lesser than current index.
 */

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        
        if(s == null || s.length()== 0 || wordDict.size() == 0){
            return false;
        }
        
        HashSet<String> set = new HashSet<>(wordDict);
        
        boolean[] dp = new boolean[s.length()+1];
        
        dp[0] = true;
        for(int i=1; i<=s.length(); i++){
            int j = 0;
            
            while(j < i){
                if(dp[j] && set.contains(s.substring(j, i))){
                    dp[i] = true;
                }   
                j++;
            }
            
            
        }
        
        //System.out.println(Arrays.toString(dp));
        
        return dp[s.length()];
    }
}