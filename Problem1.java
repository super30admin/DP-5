//https://leetcode.com/problems/word-break/
//Time complexity : O(2^N)
//Space complexity : O(N)

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> dict = new HashSet<>(wordDict);
        HashMap<Integer,Boolean> dp = new HashMap<>();
        return helper(s,0,dict,dp);
    }
    public boolean helper(String s,int index,HashSet<String> dict,HashMap<Integer,Boolean> dp){
        if(index == s.length())
            return true;
       
        if(dp.containsKey(index))
            return dp.get(index);
        
        for(int i=index+1;i<=s.length();i++){
            String str = s.substring(index,i);
            if(dict.contains(str) && helper(s,i,dict,dp)){
                dp.put(index,true);
                return true;
            }
        }
        dp.put(index,false);
        return false;
    }
}