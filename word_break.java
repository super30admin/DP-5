/*Running Time Complexity:O(n^2)
Space Complexity: O(n)
Successfully Run and Compiled on leetcode
*/
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        if(s==null || s.length()==0) return false;
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        HashSet<String> set = new HashSet<>();
        for(String word:wordDict){
            set.add(word);
        }
        for(int i = 1;i<dp.length;i++){
            for(int j = 0;j<i;j++){
                if(dp[j] && (set.contains(s.substring(j,i)))){
                    dp[i] = true;
                }
            }
        }
        return dp[dp.length-1];
    }
}