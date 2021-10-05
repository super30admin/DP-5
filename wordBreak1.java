//TC: O(N^N)
//SC: O(N) 2N for set and recursive stack

import java.util.*;
class wordBrk {
    public boolean wordBreak(String s, List<String> wordDict) {
        if(s == null || s.length() == 0){
            return false;
        }
        //store all words in set to reduce lookup time
        Set<String> set = new HashSet<>(wordDict);
        
        return helper(s, set);
        
    }
    
    private boolean helper(String s, Set<String> set){
        //base
        if(s.length() == 0){
            return true;
        }
        //logic
        for(int i = 0; i < s.length(); i++){
            if(set.contains(s.substring(0, i + 1)) && helper(s.substring(i + 1), set)){
                return true;
            }
        }
        return false;
    }
}