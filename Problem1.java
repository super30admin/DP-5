// TC : O(2^n)

//Idea : 
// 1. check each sub string is in the dictoinary.a

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        return wordBreak(s, new HashSet<>(wordDict), 0) != null;
    }
    
    
    private String wordBreak(String str, Set<String> dict, int start) {
        StringBuffer sb = new StringBuffer();
        for (int i = start; i < str.length(); i++) {
            sb.append(str.charAt(i));
            System.out.println(sb);
            if (dict.contains(sb.toString())) {
                String nextWord = wordBreak(str, dict, i + 1);
                if (nextWord != null)
                    return sb.append(" ").append(nextWord).toString();
            }
        }
        return dict.contains(sb.toString()) ? sb.toString() : null;
    }

}
// Class Soltuions

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        return helper(s,set);
    }
    
    public boolean helper(String s, HashSet<String> set){
        //base
        if(s.length() == 0) return true;
    
        for(int i=0;i<=s.length();i++){
            if(set.contains(s.substring(0,i)) &&
              helper(s.substring(i),set)){
                return true;
            }
        }
        return false;
    }
    
}
