//139. Word Break.java
//Time:O(n^2)
//Space:O(n)


class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
     
        HashSet<String> words = new HashSet<String>();
        
        for(int i = 0; i < wordDict.size();++i ){
            words.add(wordDict.get(i));
        }
        
        //dp array
        Boolean[] dp = new Boolean[s.length()+1];
        dp[0] = true;
        
        for( int i = 0; i < s.length();++i){
            
            if(dp[i] == null)
                continue;
            for( int j = 1; j <= s.length();++j){
                if(j >= i)
                {
                    String temp =s.substring(i,j);
                    
                    if(words.contains(temp)){
                        dp[j] = true;    
                    }
                }
            }
        }
        
        if(dp[s.length()] == null)
            return false;
        return dp[s.length()];
    }
}
