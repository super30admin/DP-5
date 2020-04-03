// Time Complexity : O(n^2)
// Space Complexity : O(N)


class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        
        if(s == null || s.length() == 0) return false;
        
        HashSet<String> set = new HashSet<>();
        
        for(String word: wordDict)
            set.add(word);        
        
        //place a null at the beginning
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