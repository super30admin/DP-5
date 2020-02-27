//TC : O(k^n) , k is the length of dictionary
//SC : O(1)
class Solution {
    HashSet<String> set ;
    public boolean wordBreak(String s, List<String> wordDict) {
        set = new HashSet<>(wordDict);

        if(s.length() == 0 || s==null) return false;


        return helper(s);

    }

    private boolean helper(String s){
         if(s.length() == 0) return true;


         for(int i=0;i<=s.length();i++){

             if(set.contains(s.substring(0,i)) && helper(s.substring(i)))
                return true;
         }


        return false;

    }
}