class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        
        //calling a memoized version of the recursive function.
        
        return wbMemo(s, new HashSet<>(wordDict), 0, new Boolean[s.length()]);
    }
    
    public boolean wbMemo(String s, Set<String> wordDict, int start, Boolean[] memo){
        
        
        //Base case
        
        if( start == s.length()){
            return true;
        }
        
        if(memo[start] != null){
            return memo[start];
        }
        
        //We will need a for loop for generating all the substrings from the string.
        
        for(int i = start; i < s.length(); i++){
            
            //Check in the dictionary if the broken word so far is present in the dictionary.
            
            if(wordDict.contains(s.substring(start, i + 1)) && wbMemo(s, wordDict, i + 1, memo)){
                
                //True is returned only if the previous portion and the poertion lying ahead have a match in dictionary.
                return memo[start] = true;
            }
            
            
        }return memo[start] = false;
    }
}