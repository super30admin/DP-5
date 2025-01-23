public class wordBreak {
    class Solution {
        public boolean wordBreak(String s, List<String> wordDict) {
           HashSet<String> set = new HashSet<>(wordDict);
           HashMap<String, Boolean> map = new HashMap<>();
           return helper(s,set,map);
       }
   
       private boolean helper(String s, HashSet<String> set, HashMap<String, Boolean> map) {
           if(s.length() == 0) return true;
   
           for(int i=0;i<s.length();i++) {
               String sub = s.substring(0,i+1);
               if(set.contains(sub)) {
                   String subst = s.substring(i+1);
                   if(!map.containsKey(subst)) {
                       boolean re = helper(subst,set,map);
                       map.put(subst, re);
                   }
                   if(map.get(subst)) {
                       return true;
                   }
               }
           }
   
           return false;
       }
   }
}
