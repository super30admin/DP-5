// Time Complexity : O(N ^3)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n =s.length();
        boolean[] dp = new boolean[n+1];

        HashSet<String> set = new HashSet<>(wordDict);

        dp[0] = true;

        for(int i=1;i<=n;i++){ //O(N)
            for(int j=i-1;j>=0;j--){ //O(N)
                if(dp[j] && set.contains(s.substring(j,i))) { //O(N)
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n];
    }
}
// Recursion
// Time Complexity : O(N * M *K)
// Space Complexity : O(N)
class Solution {
    HashSet<String> set;
    HashMap<String,Boolean> map;
    public boolean wordBreak(String s, List<String> wordDict) {
        this.set = new HashSet<>(wordDict);
        this.map = new HashMap<>();
        return dfs(s,0);
    }

    private boolean dfs(String s, int pivot){
        if(pivot == s.length()){
            return true;
        }

        for(int i=pivot;i< s.length();i++){
            String substr = s.substring(pivot, i+1);
            if(set.contains(substr)){
                String remStr = s.substring(i+1);
                if(!map.containsKey(remStr)){
                    boolean result = dfs(s,i+1);
                    map.put(remStr, result);
                    if(dfs(s,i+1)){
                        return true;
                    }
                }

                if(map.get(remStr)){
                    return true;
                }

            }
        }
        return false;
    }
}