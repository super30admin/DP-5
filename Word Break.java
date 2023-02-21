// Recursive Solution
// Time Complexity= O(n^n)

// class Solution {
//     HashSet<String> set;
    
//     public boolean wordBreak(String s, List<String> wordDict) {
//         set = new HashSet<>(wordDict);
//         return dfs(s, 0);
//     }
    
//     private boolean dfs(String s, int idx){
//         //base
//         if(idx == s.length()){
//             return true;
//         }
//         //logic
        
//         for(int i = idx; i<s.length(); i++){
//             String sub = s.substring(idx, i+1);
//             if(set.contains(sub) && dfs(s, i+1)){
//                 return true;
//             }
//         }
//         return false;
//     }
// }

// Time Complexity = O(n^3 or n^4)
// Space Complexity = O(n)

class Solution {
    HashSet<String> set;
    public boolean wordBreak(String s, List<String> wordDict) {
        set = new HashSet<>(wordDict); //n*l
        int l = s.length();
        boolean [] dp = new boolean[l + 1];
        dp [0] = true;
        for(int i = 1; i< dp.length; i++){
            for(int j = 0; j< i; j++){
                if(dp[j] && set.contains(s.substring(j,i))){ //
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[l];
    }
}
