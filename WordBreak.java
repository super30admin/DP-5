// DP
// TC=O(n^3)
// SC=O(n)
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);  //SC=O(mxl+n)
        boolean dp[]= new boolean[s.length()+1];
        dp[0]= true;
        
        for(int i=1;i <dp.length;i++){  //n
            for(int j=0;j<i;j++){       //n
                if(dp[j]==true && set.contains(s.substring(j,i))){  //n
                    dp[i]= true;
                    break;
                }
        
            }
        }
        
        return dp[dp.length-1];
    }
}
