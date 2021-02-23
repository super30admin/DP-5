class WordBreak {
    /*
      Brute force
    */
    HashSet<String> set = new HashSet<>();
    public boolean wordBreak(String s, List<String> wordDict) {
        // brut force,
        set = new HashSet<>(wordDict);
        
        
        return helper(s);
    }
    
    private boolean helper(String s){
        
        if(s.length() == 0) return true;
        // logic
        for(int i = 0; i < s.length(); i++){
            if(set.contains(s.substring(0,i+1)) && helper(s.substring(i+1))){
                return true;
            }
        }
        
        return false;
    }
}
