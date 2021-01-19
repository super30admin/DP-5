// Time Complexity : O(n*k) 
// Space Complexity :O(n) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :  No


// Your code here along with comments explaining your approach: Store the words in Hashset for O(1) runtime for checking. Also maintain a 
// boolean array for checking whether the word can be formed uptil that point in the array. return true if the last value in the array is true.
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        if(s==null||s.length()==0)
            return true;
        boolean[] dp = new boolean[s.length()+1];
        HashSet<String> dict = new HashSet<>(wordDict);
        dp[0]=true;
        for(int i=1;i<dp.length;i++){
            for(int j=0;j<i;j++){
                if(dp[j] && dict.contains(s.substring(j,i))){
                    dp[i]=true;
                    break;
                }
            }
        }
        return dp[dp.length -1];
    }
}