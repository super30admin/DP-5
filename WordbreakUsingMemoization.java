// Time Complexity : O(n^3) -> n is the length of the string
// Space Complexity : O(n*l)+O(n^3)
// -> for hashset n*l -> n is the number of words in dict and l is the avg length of each word
//-> for hashmap n^3 -> to store all the possible combination of words
// Did this code successfully run on Leetcode : Yes


import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class WordbreakUsingMemoization {
    HashSet<String> set;
    HashMap<String, Boolean> memoMap;
    public boolean wordBreak(String s, List<String> wordDict) {
        memoMap = new HashMap<>();  // l^3
        set = new HashSet<>(wordDict);  // n*l
        return helper(s);
    }

    public boolean helper(String s)
    {
        if(s.length() == 0)return true;
        for(int i=0; i<s.length(); i++)// n^3
        {
            String sub = s.substring(0,i+1);
            if(set.contains(sub))
            {
                String remStr = s.substring(i+1);
                if(!memoMap.containsKey(remStr))
                {
                    memoMap.put(remStr,helper(remStr));
                }
                if(memoMap.get(remStr))
                    return true;
            }
        }
        return false;
    }
}