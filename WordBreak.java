 //TC : O(n^2)  , n is the length of string
//SC : O(n) , size of dp array
class Solution {
    HashSet<String> set ;
    public boolean wordBreak(String s, List<String> wordDict) {
         set = new HashSet<>(wordDict);
        
        int[] dp = new int[s.length()+1];

        dp[0] = 1;

        for(int i=0;i<dp.length;i++){

            for(int j=0;j<dp.length;j++){
                //Setting 1 only if the substring present in hashset
                if(dp[j] == 1 && set.contains(s.substring(j,i)))
                    dp[i] = 1;
            }

        }

        if(dp[s.length()] == 1)
            return true;
        
        return false;
        
    }
}