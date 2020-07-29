// 139.
// problem - check if s can be made from the words in dict with possible reuse of same words
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> dict = new HashSet<>(wordDict); //set allows fast lookup
        //return helper(s, dict);
        return validPartition(s, dict);
    }
    
    //time - O(n^n)
    //space - O(n) for the call stack
    private boolean helper(String s, HashSet<String> dict) {
        //base
        if(s.length() == 0)
        {
            return true; //cursor percolates down to empty string - hits base and returns true
        }
        //logic
        for(int i = 1; i <= s.length(); i++)
        {
            String snippet = s.substring(0, i);
            String remaining = s.substring(i);
            //process the branch only if the snippet is in the dict
            if(dict.contains(snippet) && helper(remaining, dict))
            {
                return true;
            }
        }
        return false;
    }
    
    //time - O(n^2)
    //space - O(n)
    private boolean validPartition(String s, HashSet<String> dict) {
        boolean[] result = new boolean[s.length() + 1];
        result[0] = true; //'' is part of dict
        for(int i = 1; i < result.length; i++)
        {
            for(int j = 0; j < i; j++)
            {
                String snippet = s.substring(j, i); 
                if(result[j] && dict.contains(snippet)) 
                {
                    //result[j] = true implies that the substring s[0,j] ccan be formed from words in dict
                    //current snippet must be in dict
                    //so thw whole substring from s[0,i] is valid and thus made true
                    result[i] = true;
                }
            }
        }
        return result[result.length - 1];
    }
}


// call stack
// s = "code"  dict = [c, od, e, x]
//                                             wb(code)
//                                                 |
//                  c && wb(ode)    co && wb(de)   cod && wb(e)   code && wb()   co, cod, code are not in dict
//             (True)   |            (False)         (False)        (False)        so dont expand those branches
//                      |           
//         o && wb(de)  od && wb(e)   ode && wb()   
//       (False)        (True)  |      (False)
//                              |
//                        e && wb()    e is there in dict and base is hit so return true
//                      (True)  (True)
