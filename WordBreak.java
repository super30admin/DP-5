class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int[]dp = new int[s.length()];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<=i;j++){
                String wordBreak = s.substring(j,i+1);
                if(wordDict.contains(wordBreak)){
                    if(j>0){
                        dp[i] += dp[j-1];
                    }else{
                        dp[i] += 1;
                    }
                }
            }
        }
        return dp[dp.length-1] >0;
    }
}

//Time complexity : O(N^3)
//Space complexity : O(N)
