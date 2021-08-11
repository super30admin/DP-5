// Time Complexity : O(n ^ n)
// Space Complexity : O(n)

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        if(s == null || s.length() == 0)
           return false;
        Set<String> set = new HashSet<>(wordDict);
        return helper(s, set);
    }
    
    private boolean helper(String s, Set<String> set){
        //base
        if(s.length() == 0)
            return true;
        
        //logic
        for(int i = 1; i <= s.length(); i++){
            if(set.contains(s.substring(0, i)) && helper(s.substring(i), set))
                return true;
        }
        
        return false;
    }
}