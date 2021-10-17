class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        if(s==null) return false;
        Set<String> set = new HashSet(wordDict);
        return helper(s, set);
    }
    
    public boolean helper(String s, Set<String> set) {
        if(s.length()==0) return true;
        
        for(int i=0; i<s.length(); i++) {
            if(set.contains(s.substring(0, i+1)) && helper(s.substring(i+1), set)) return true;
        }
        return false;
    }
}