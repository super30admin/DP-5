//Time complexity : O(n*2)
//Space Complexity : O(n)

class Solution {
    HashSet<String> set;
    public boolean wordBreak(String s, List<String> wordDict) {
        if(s ==  null || s.length() == 0  || wordDict == null){
            return false;
        }
        set  =  new HashSet(wordDict);
        int n = s.length();
        int[]  dp = new int[n+1];
        dp[0] = 1;
        for(int i = 1; i<n+1; i++){
            for (int j = 0; j<i; j++){
                if(dp[j] == 1){
                    if(set.contains(s.substring(j,i))){
                        dp[i] = 1;
                    }
                }
            }
        }
        return dp[n] == 1;
    }
}