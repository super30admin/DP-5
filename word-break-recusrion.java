
/*

Did it run on leetcode: TLE
Time complexity: 0(N*2)
Space Complexity: 0(N*2)

Algorithm:
- Break the word in two words at each character
- recursively do the same for the both the words where we have branched out.


*/


class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        
        HashSet<String> set = new HashSet<>(wordDict);
        return helper(s,set);
    }
    
    private boolean helper(String s, HashSet<String>set){
        
        if(s.length()==0){
            return true;
        }
        
        int len = s.length();
        
        for(int i=0;i<=len;++i){
            if(set.contains(s.substring(0,i)) && helper(s.substring(i),set)){
                return true;
            }
        }
        
        return false;
        
    }
}