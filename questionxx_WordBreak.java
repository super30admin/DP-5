package DynamicProgramming5;

import java.util.HashSet;
import java.util.List;

public class questionxx_WordBreak {
    /** https://leetcode.com/problems/word-break/   */
    /* Created by palak on 7/30/2021 */

    /**
     Brute Force Solution:
     Time Complexity: O(n * n)
     Space Complexity: O(n);
     */
    public static boolean wordBreak1(String s, List<String> wordDict) {
        if(s == null)   return false;
        HashSet<String> set = new HashSet<>(wordDict);
        return helper(s, set);
    }
    private static boolean helper(String s, HashSet<String> set) {
        // Base
        if(s.length() == 0) return true;

        // Logic
        for(int i = 1 ; i <= s.length() ; i++) {
            if(set.contains(s.substring(0, i)) && helper(s.substring(i), set))
                return true;
        }
        return false;
    }
}
