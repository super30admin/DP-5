// Time Complexity :O(N^2*k)
// Space Complexity :O(N+k)
// Did this code successfully run on Leetcode :Yess
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach: recursive DP
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set= new HashSet<>(wordDict);
        
        return helper(s, set);
    }

    public boolean helper(String s, HashSet<String> set){
        if(s.length()==0) return true;

        for(int i=0; i<s.length();i++){
            if(set.contains(s.substring(0,i+1)) && helper(s.substring(i+1), set)){
                return true;
            }
        }
        return false;
    }
}