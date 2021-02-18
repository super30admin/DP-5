/*
brute force recursion, gives Time limit exceeded: try all possible substrings

metohd 2: using dp array to store the result
time complexity: O(n^3)
space :O(n)

*/
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        if(s == null || s.length() == 0)return false;
        
        
        HashSet<String> set = new HashSet<>(wordDict);
        //mmethod 1
        //return helper(s,set);
        
        boolean[]dp = new boolean[s.length()+1];
        dp[0] = true;
        for(int i = 1; i < dp.length;i++){ //O(n)
            for(int j = 0; j < i; j++){   //O(n)
                String subStr = s.substring(j,i); //O(n)
                if(dp[j] && set.contains(subStr)){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[dp.length-1];
    }
    
    private boolean helper(String s, HashSet<String> set){
        if(s.length() == 0){
            return true;
        }
        
        //logic
        for(int i = 0; i < s.length();i++){
            if(set.contains(s.substring(0,i+1)) && helper(s.substring(i+1),set) ){
                return true;
            }
        }
        return false;
    }
}