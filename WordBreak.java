
//time complexity = m * l + n3
//Space complexity: O(n+m⋅l)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class Solution {

    public boolean wordBreak(String s, List<String> wordDict) {
       HashSet<String> set = new HashSet<>(wordDict);  //m*l , l is average length of word. M is length of dictonary
       int n = s.length();
       boolean[] dp  = new boolean[n+1];
       dp[0] = true;
        for(int i=1; i<=n; i++) { //n
            for(int j=0; j <i; j++){// n2
                if(dp[j] && set.contains(s.substring(j,i))){ //n3
                    dp[i] = true;
                    break;
                }
                
            }
            
        }
        return dp[n];
    }
    
}
