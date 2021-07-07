
/**
LeetCode Submitted : No (Time Limit Exceed Error)
Space Complexity : O(1)
Time Complexity : O(2^N)

The idea is to recursively check all the possible substring at each position if it matches entries in the HashSet otherwise continue checking next available substring. If we find a word check if we find other remaining word in the dictionary taking that as one possible word

**/




class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
     
        if(s == null || s.length() < 1)
            return false;
        
        Set<String> set = new HashSet<>(wordDict);
        
        return checkWords(s,set);
        
    }
    
    private boolean checkWords(String s, Set<String> set){
        //if we encounter end of string
        if(s.length() == 0)
            return true;
        
        for(int i = 0; i<s.length()+1;i++){
            if(set.contains(s.substring(0,i))) 
               if(checkWords(s.substring(i),set))
                   return true;
            }
        return false;
    }
}
