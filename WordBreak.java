// Recursion solution (Time limit will exceed)
// Approach:
//The thought process is to basically check every substring and check if the chunks match against the word dict
running a for loop with a checking if left part of string divison is present in the dictionary AND making a recursive call to the right part of string
//Code:
class Solution {
      HashSet<String> set;
    public boolean wordBreak(String s, List<String> wordDict) {
     if ( s == null || s.length() == 0){
        return false;
     }    
         set = new HashSet<>(wordDict);

     return recurse(s);
    }
    private boolean recurse(String s){
        // base
        if (s.length() == 0){
            return true;
        }
        // logic
        for (int i =0; i < s.length();i++){
            if (set.contains(s.substring(0,i+1))&& recurse(s.substring(i+1)))
            return true;
        }
        return false;

    }
}
//Time Complexity is exponential above


// DP SOLUTION
class Solution {
    //Time Complexity:O(n^3)
    //Space Complexity:O(n + mk)
      HashSet<String> set;
    public boolean wordBreak(String s, List<String> wordDict) {
     if ( s == null || s.length() == 0){
        return false;
     }    
         set = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length()+1];
        dp[0] =true;
        for (int i =0;i < dp.length;i++){
            // initiate a j pointer at start and we'll check between i and j and the left of j
            for (int j = 0; j < i;j++){
                if (dp[j] && set.contains(s.substring(j,i))){
                    dp[i] = true;
                    break;
                }

            }
        }
        return dp[dp.length-1];
    }
}
