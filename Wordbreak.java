// Time Complexity :O(n*l)(2*n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
// here we do for loop based recursion, we have a choice to split the word at each position
// check if exists in dict
// we might end up checking for same word again if we know it wont be possible for wordbreak / it is not present in dict
// so we store each broken substring in memoset, if we already have it we return false
// else if the original dict constains the substring we return true
import java.util.*;

public class Solution {

    HashSet<String> dict;
    HashSet<String> memoSet;

    public boolean wordBreak(String s, List<String> wordDict) {

        this.dict = new HashSet<>(wordDict);
        this.memoSet = new HashSet<>();

        return helper(s);
    }

    private boolean helper(String s) {

        if (s.length() == 0) {
            return true;
        }

        if (memoSet.contains(s)) {
            return false;
        }

        for (int i = 0; i < s.length(); i++) {

            String substr = s.substring(0, i + 1);

            if (dict.contains(substr)) {

                if (helper(s.substring(i + 1))) {
                    return true;
                }
            }
        }

        memoSet.add(s);

        return false;
    }
}