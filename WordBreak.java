// Time Complexity : O(n*m*k) where h = ht of BST
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Approach -
//   - Use a HashSet for fast lookup of words from the dictionary.
//   - Use a recursive helper method with memoization to check if the string can be segmented.
//   - At each pivot, try all substrings and recursively check the rest of the string.
//   - If a valid segmentation is found, return true. Else, memoize and return false.

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class WordBreak {
    // private boolean __wb(String s, List<String> wordDict, int pos) {
    //     if(pos == s.length()) {
    //         return true;
    //     }
    //     String temp = "";
    //     for(int i=pos; i<s.length(); i++) {
    //         boolean left = wordDict.contains(s.substring(pos, i-pos+1));
    //         if(left && __wb(s, wordDict, i+1)) {
    //             return true;
    //         }
    //     }
    //     return false;
    // }


    // public boolean wordBreak(String s, List<String> wordDict) {
    //     return __wb(s, wordDict, 0);
    // }

    //Memoization - TC - O(n*m*k) where n=len of string, m=size of list, k=substr operations time, SC = O(n) due to map
    HashSet<String> set;
    HashMap<String, Boolean> memoMap;
    public boolean wordBreak(String s, List<String> wordDict) {
        this.set = new HashSet<>(wordDict);
        this.memoMap = new HashMap<>();
        return helper(s, 0);
    }

    //use pivot based recurssion
    private boolean helper(String s, int pivot) {
        if(pivot == s.length()) return true;
        String str = s.substring(pivot);

        if(memoMap.containsKey(str))
            return false;

        for(int i = pivot; i < s.length(); i++) {
            String subStr = s.substring(pivot, i + 1);
            if(set.contains(subStr)) {  //one word found in list then look for other word
                if(helper(s, i + 1)) {  //we found other word as well
                    return true;
                }
            }
        }

        memoMap.put(str, false);
        return false;
    }

    public static void main(String[] args) {
        WordBreak obj = new WordBreak();
        List<String> wordDict = List.of("leet", "code");
        String s = "leetcode";
        boolean result = obj.wordBreak(s, wordDict);
        System.out.println("Can the string be segmented? " + result); // Expected: true

        List<String> wordDict2 = List.of("apple", "pen");
        String s2 = "applepenapple";
        boolean result2 = obj.wordBreak(s2, wordDict2);
        System.out.println("Can the string be segmented? " + result2); // Expected: true

        List<String> wordDict3 = List.of("cats", "dog", "sand", "and", "cat");
        String s3 = "catsandog";
        boolean result3 = obj.wordBreak(s3, wordDict3);
        System.out.println("Can the string be segmented? " + result3); // Expected: false
    }
}
