//tc = ml +n^3
//sc = O(n) + ml

// import java.util.HashSet;
// import java.util.List;

// public class WordBreak {

// }

// class Solution {
//     HashSet<String> st;

//     public boolean wordBreak(String s, List<String> wordDict) {
//         this.st = new HashSet<>(wordDict);
//         return helper(s);
//     }

//     private boolean helper(String s) {
//         // base
//         if (s.length() == 0)
//             return true;

//         // logic
//         for (int i = 0; i < s.length(); i++) {
//             String s1 = s.substring(0, i + 1);
//             if (st.contains(s1) && helper(s.substring(i + 1))) {
//                 return true;
//             }
//         }
//         return false;

//     }
// }

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

// class Solution {
//     HashSet<String> st;
//     HashMap<String, Boolean> map;

//     public boolean wordBreak(String s, List<String> wordDict) {
//         this.st = new HashSet<>(wordDict);
//         this.map = new HashMap<>();
//         return helper(s);
//     }

//     // top down dp
//     private boolean helper(String s) {
//         // base
//         if (s.length() == 0)
//             return true;

//         // logic
//         for (int i = 0; i < s.length(); i++) {
//             String sub = s.substring(0, i + 1);
//             if (st.contains(sub)) {
//                 String s1 = s.substring(i + 1);
//                 if (!map.containsKey(s1)) {
//                     boolean result = helper(s1);
//                     map.put(s1, result);
//                 }
//                 boolean value = map.get(s1);
//                 if (value)
//                     return true;
//             }
//         }
//         return false;

//     }
// }

class Solution {
    HashSet<String> st;
    public boolean wordBreak(String s, List<String> wordDict) {
        this.st = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        for(int i = 1 ; i < dp.length ; i++){
            for (int j = 0 ; j < i ; j++){
                if(dp[j] && st.contains(s.substring(j,i))){
                  dp[i] = true;
                  break;
                }

            }
           
        }
      return dp[s.length()];
    }
}
