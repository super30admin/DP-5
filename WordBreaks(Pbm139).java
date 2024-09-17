/*
Algorithem:
    1. Take a dp array with first element as 1.
    2. Take 2 pts, j and i for every i start from 0 to i and check if substring(j,i) is in the set then mark dp[i] as 1.
    3. Return true if dp[last element] is 1 else fasle;
    
    Time Complexity: O(n * n)
    Space Complexity: O(n)
*/


class Solution {
    
    HashSet<String> set;
    public boolean wordBreak(String s, List<String> wordDict) {
        
        if(s==null || s.length()==0)
            return false;
        
        set = new HashSet<>(wordDict);
        
        int dp[] = new int[s.length()+1];
        dp[0] = 1;
        
        for(int i=1; i<dp.length; i++){
            for(int j=0; j<i; j++){
                if(dp[j]==1){
                    if(set.contains(s.substring(j,i)))
                        dp[i] = 1;
                }
            }
        }
        
        if(dp[dp.length-1]==1)
            return true;
        else
            return false;
    }
    
}