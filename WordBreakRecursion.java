package DP5;

import java.util.HashSet;
import java.util.List;

/*
        -------------------------------------------------------------------------------------------------------
        Time complexity : o(n power n)
        space complexity: o(n power n)
        Did this code run successfully in leetcode : yes
        problems faces : no
 */
    
public class WordBreakRecursion {
    
public boolean wordBreak(String s, List<String> wordDict) {
    
    if(s == null || s.length() ==0 ) return false;
    
    HashSet<String> set = new HashSet<String>(wordDict);
    return  helper(s,set);
    
    }

private boolean helper(String s, HashSet<String> set) {
    
    //base
    if(s.length() == 0) return true;
    
    //logic
    for(int i=1;i<s.length();i++)
    {
        if(set.contains(s.substring(0, i)) && helper(s.substring(i),set) )
        {
            return true;
        }
    }
    
    return false;
}

}
