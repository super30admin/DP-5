//Time Complexity - O(n^4)
//Space Complexity - O(n) - n is number of words in dictionary

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
       if(s == null) return false;
       HashSet<String> set = new HashSet<>(wordDict);
       int n = s.length()+1;
       boolean [] dp = new boolean[n];
      dp[0] = true;
      for(int i = 1; i< n; i++) {
        for(int j =0; j< i;j++) {
        //check substring from j to letter at previous index of i is in the set or not
          if(dp[j] && set.contains(s.substring(j,i))) {
            //if the word is in the dictionary then setting boolean value to true
            dp[i] = true;
            //Once the substring is found then no need to check how the string is split for that string
            break;
          }
        }
      }
      return dp[dp.length-1];
    }
}