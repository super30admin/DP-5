// tc = O(n^4)
// sc = O(m*n);


class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length()+1];
        HashSet<String> set = new HashSet<>();
        
        for(String word:wordDict){
            set.add(word);
        }
        
        dp[0]=true;
        
        for(int i=1;i<s.length()+1;i++){
            for(int j=0;j<i;j++){
                if(!dp[j]) continue;
                if(set.contains(s.substring(j,i))){
                    dp[i]=true;
                    break;
                }
            }
        }
        
        return dp[s.length()];
    }
}
