// # DP-5

// ## Problem1: (https://leetcode.com/problems/word-break/)

// Time Complexity : O(n^2)
// Space Complexity : O(n^2)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : I didnt face any problem while coding this.

class Solution {
    HashMap<String, Boolean> map;
    public boolean wordBreak(String s, List<String> wordDict) {
        this.map = new HashMap<>();
        HashSet<String> set = new HashSet<>(wordDict);
        return helper(s, set);

    }

    private boolean helper(String s, HashSet<String> set){
        if(s.length() == 0) return true;

        for(int i=0; i<s.length(); i++){
            String sub = s.substring(0, i+1);
                if(set.contains(sub)){
                    String subst = s.substring(i+1);
                        if(!map.containsKey(subst)){
                            boolean re = helper(subst, set);
                            map.put(subst, re);
                        }
                        if(map.get(subst)){
                            return map.get(subst);
                        }
                        
                    }
                }
                return false;
            }
        }


// ## Problem2: (https://leetcode.com/problems/unique-paths/)

// Time Complexity : O(n^2)
// Space Complexity : O(n^2)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : I didnt face any problem while coding this.

class Solution {
    public int uniquePaths(int m, int n) {
       int[][] dp = new int[m][n];
       for(int j=0; j<n; j++){
           dp[m-1][j] = 1;
       } 

       for(int i=0; i<m; i++){
           dp[i][n-1] = 1;
       }

       for(int i=m-2; i>=0; i--){
           for(int j=n-2; j>=0; j--){
               dp[i][j] = dp[i+1][j] + dp[i][j+1];
           }
       }
       return dp[0][0];
    }
}