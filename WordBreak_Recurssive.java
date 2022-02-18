//Recursive func -- Time limit exceeds
//TC: )(n ^ n)
//SC : O(n)
class Solution {
    HashSet<String> set;
    public boolean wordBreak(String s, List<String> wordDict) {
        
        set = new HashSet<>(wordDict);
        return helper(s);
    }
    
    private boolean helper(String curr){
        //null
        if(curr.length() == 0) return true;
        //logic 
       for(int i=0; i< curr.length(); i++){
           String substrng = curr.substring(0, i+1);
           if(set.contains(substrng) && helper(curr.substring(i+1))){
               return true;
           }
       }
        return false;
    }
}