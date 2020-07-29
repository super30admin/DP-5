// Time Complexity : O(n^n)
// Space Complexity : O(n) - maximum stack calls 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach: Using a hashset for O(1) access. For each substring from 0 to the entire length, we check if the first part is in the set and also recursively check if the second part(/the rest of the string) is present recursively. So we end up doing bottum up recursion.

class Solution {
    HashSet<String> set;
    public boolean wordBreak(String s, List<String> wordDict) {
        set=new HashSet<>(wordDict);
        return helper(s);
    }
    
    public boolean helper(String s){
        if(s.length()==0) return true;
        for(int i=0;i<=s.length();i++){
           if(set.contains(s.substring(0,i)) && helper(s.substring(i))){
               return true;
           }
        }
        return false;
    }
}

// Time Complexity : O(n^2)
// Space Complexity : O(n) - dp array space.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach: We use a dp array with one extra space and check if the set contains a substring from the points wherever dp[j]==true from a particular index.


class Solution {
    HashSet<String> set;
    public boolean wordBreak(String s, List<String> wordDict) {
        set=new HashSet<>(wordDict);
        boolean[] dp=new boolean[s.length()+1];
        dp[0]=true;
        for(int i=1;i<dp.length;i++){
            for(int j=0;j<i;j++){
                if(dp[j]==true && set.contains(s.substring(j,i))){
                      dp[i]=true;
                       break;
                    }
                }
            }
        return dp[dp.length-1];
    }
    

}