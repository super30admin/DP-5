
time complexity: O(string length * dict size)
space complexity: O(1)

//using DP, define an array t[] such that t[i]==true => 0-(i-1) can be segmented using dictionary, Initial state t[0] == true

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
       boolean[] t = new boolean[s.length()+1];
        t[0] = true; //set first to be true, why?
        //Because we need initial state
 
        for(int i=0; i<s.length(); i++){
            //should continue from match position
            if(!t[i]) 
                continue;
 
            for(String a: wordDict){
                int len = a.length();
                int end = i + len;
                if(end > s.length())
                    continue;
 
                if(t[end]) continue;
 
                if(s.substring(i, end).equals(a)){
                    t[end] = true;
                }
            }
        }
 
        return t[s.length()]; 
    }
}
