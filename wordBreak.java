// Time Complexity : O(n^2)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
//See the image

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        
        //base check
        if(s == null || s.length() == 0) return false;
        
        //initialize a hashset to store all the results
        HashSet<String> set = new HashSet<>();
        
        for(String word: wordDict)
            set.add(word);        
        
        //introduce a null at the beginning
        s = "^" + s;
        
        //initialize boolean array
        boolean[] isValid = new boolean[s.length()];
        
        //if i == 0, then put true
        isValid[0] = true;
        
        for(int i = 1; i < s.length(); i++){
            
            int k = i;
            
            while(k>=1){
              if(set.contains(s.substring(k, i+1)) && isValid[k-1]){
                  isValid[i] = true;
                  break;
              }
                k--;
            }
        }
        
        return isValid[s.length()-1];
    }
}