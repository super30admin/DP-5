// 139 Word break
// time - O(n3)
// space - O(n)
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        
        HashSet<String> dict = new HashSet<>(wordDict);
        int[] dp = new int[s.length() + 1];
        
        for(int i = 1; i < dp.length; i++){
            
            String currString = s.substring(0, i);
            
            if(!dict.contains(currString)){
                
                for(int j = 1; j < i; j++){
                    
                    if(dp[j] == 1 && dict.contains(s.substring(j, i))){
                        dp[i] = 1;
                        break;  
                    }
                }
                
                
            }else{
                dp[i] = 1;
            }
        }
        
        return (dp[dp.length - 1] == 1);
        
    }
}