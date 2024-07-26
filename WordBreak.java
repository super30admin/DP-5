//TC - O(n3)
//SC - O(n)
class Solution {
    HashSet<String> hashSet;
    public boolean wordBreak(String s, List<String> wordDict) {
        if(s == null || s.length() == 0){
            return false;
        }
        hashSet = new HashSet<>(wordDict);
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        // int i = 1;
        // int j = 0;
        for(int i = 1; i < n + 1; i++){
            for(int j = 0; j < i; j++){
                if(dp[j] == true){
                    if(hashSet.contains(s.substring(j,i))){
                        dp[i] = true;
                        break;
                    }
                }

            }

        }
        
       return dp[n]; 
    }
    
}
