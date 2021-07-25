//Time Complexity - O(n^n)
//Space Complexity - O(n) - n is number of words in dictionary

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
       if(s == null) return false;
       HashSet<String> set = new HashSet<>(wordDict);
      return helper(s,set);
    }
  
    private boolean helper(String s, HashSet<String> set) {
      //base case
      if(s.length() == 0) return true;
      //logic
      for(int i = 1; i<= s.length();i++) {
        if(set.contains(s.substring(0,i)) && helper(s.substring(i),set)){
          return true;
        } 
      }
      return false;
    }
}