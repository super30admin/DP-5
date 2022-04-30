//SC : O(m) -- m = length of s
//TC : O(n) -- n = length of wordDict 
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        boolean[] dict = new boolean[s.length() + 1];
        
        dict[0] = true;
        for(int i = 0; i< dict.length; i++){
            for(int j = 0; j< i; j++){
                String str = s.substring(j, i); //j to i-1
                if(dict[j] && set.contains(str)){
                    dict[i] = true;
                    break;
                }
            }
        }
        return dict[s.length()];

    }
}


/*
//Time limit exceeded
//TC : O(2^N)
//SC : O(N)

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        
        return check(s, set);
    }
    public boolean check(String s, HashSet<String> set){
        if(s.length() == 0)   return true;
        
        for(int i = 0; i< s.length(); i++){
            String str = s.substring(0, i + 1);
            if(set.contains(str) && check(s.substring(i+1), set))   return true;
        }
        return false;
    }
}

*/











