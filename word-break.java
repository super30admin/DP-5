//Brute Force
//Make all possible substrings starting from first character
//Is the substring there inside a dict (hashmap/set or Trie) and rest of the string can be divided into substring
// //For loop based recursion. same can b done with 0-1 based recursion
// //Time = O(ml + 2^n)
// //Space = O(n), recursive stack
// class Solution {
//     public boolean wordBreak(String s, List<String> wordDict) {
//         HashSet<String> set = new HashSet<>(wordDict);
//         int n = s.length();
//         return helper(s, set, 0);
//     }
// //boolean based recursion. void based can be done as well.
//     private boolean helper(String s, HashSet<String> set, int pivot){
//         //base
//         if(pivot==s.length()) return true;
//         //logic
//         for(int i=pivot; i<s.length(); i++){
//             String subStr = s.substring(pivot, i+1);
//             if(set.contains(subStr) && helper(s, set, i+1)){
//                 return true;
//             }
//         }
//         return false;
//     }
// }


// //DP - memoization, top-down
// //Time = O(n^3)
// class Solution {
//     HashMap<String, Boolean> memoMap;
//     public boolean wordBreak(String s, List<String> wordDict) {
//         this.memoMap = new HashMap<>();
//         HashSet<String> set = new HashSet<>(wordDict);
//         int n = s.length();
//         return helper(s, set);
//     }
//     private boolean helper(String s, HashSet<String> set){
//         //base
//         if(s.length()==0) return true;
//         if(memoMap.containsKey(s)) return memoMap.get(s);
//         //logic
//         for(int i=0; i<s.length(); i++){
//             String subStr = s.substring(0, i+1);
//             if(set.contains(subStr) && helper(s.substring(i+1), set)){
//                 memoMap.put(s,true);
//                 return true;
//             }
//         }
//         memoMap.put(s,false);
//         return false;
//     }
// }


//Sub problems- hence DP
//tabulation - bottom up DP
//Time = O(n^3)
//Space = O()
class Solution {
    HashMap<String, Boolean> memoMap;
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        boolean [] dp = new boolean[s.length()+1];
        dp[0] = true;
        for(int i=1; i<dp.length; i++){
            for(int j=0; j<i; j++){
                if(dp[j] && set.contains(s.substring(j,i))){
                    dp[i]=true;
                    break;
                }
            }
        }
        return dp[dp.length-1];
    }
}