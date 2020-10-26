//Time complexity : O(n * n) where n is the length of the string
//Space complexity : O(n) where n is the length of the given string.

import java.util.*;

public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        if(s == null || s.length() == 0 
            || wordDict == null || wordDict.isEmpty()) {
            return false;
        }
        
        Set<String> hashSet = new HashSet<>(wordDict);
        
        int[] DP = new int[s.length() + 1];
        DP[0] = 1;
        int end = 1;
        
        while(end <= s.length()) {
            int start = 0;
            while(start<end) {
                if(DP[start] == 1 
                   && hashSet.contains(s.substring(start, end))) {
                    DP[end] = 1;
                    break;
                }
                start++;
            }
            end++;
        }
        
        return DP[s.length()] == 1;
    }
}
