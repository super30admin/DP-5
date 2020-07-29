// Time complexity - O(n^n)
//Space complexity - O(n), n = length of string

class Solution {
    Set<String> set;
    public boolean wordBreak(String s, List<String> wordDict) {
        set = new HashSet<>(wordDict);
        return helper(s);
    }
    
    private boolean helper(String s){
        // base
        if(s.length() == 0){
            return true;
        }
        
        // logic
        for(int i = 0 ; i <= s.length(); i++){
            if(set.contains(s.substring(0,i)) && helper(s.substring(i))){
                return true;
            }
        }
        return false;
    }
}
