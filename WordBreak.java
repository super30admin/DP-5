import java.util.*;

/**
 * Leetcode 139. Word Break
 * Link: https://leetcode.com/problems/word-break/description/
 */
//------------------------------------ Solution 1 -----------------------------------
public class WordBreak {
    /**
     * Brute force exhaustive solution. In this solution we first convert wordDict to hashset so that we can lookup any
     * substring created from s is part of the wordDict or not in constant time. The main logic is to create all possible
     * substrings by making string splits from start to end of the string. left part of substring is checked directly if
     * it is in hashset or not and the right substring is solved recursively.
     *
     * TC: O(2^n + ml) n length of string s, m words in dictionary and l is max length of a word
     * Auxiliary SC: O(ml) m words in dictionary and l is max length
     * Recursive stack SC: O(n) height/depth of the recursive tree
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> strSet = new HashSet<>(wordDict);
        return helper(s, strSet, 0);
    }

    private boolean helper(String s, Set<String> strSet, int pivot) {
        //base
        if (pivot == s.length()) {
            return true;
        }

        //logic
        for (int i = pivot; i < s.length(); i++) {
            String subStr = s.substring(pivot, i + 1);

            if(strSet.contains(subStr) && helper(s, strSet, i + 1)) {
                return true;
            }
        }
        return false;
    }
}

//------------------------------------ Solution 2 -----------------------------------
class WordBreak2 {
    /**
     * Same as above solution, just we are fixing pivot at 0 so we don't need it.
     *
     * TC: same as above
     * Auxiliary SC: same as above
     * Recursive stack SC: same as above
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> strSet = new HashSet<>(wordDict);
        return helper(s, strSet);
    }

    private boolean helper(String s, Set<String> strSet) {
        //base
        if (s.isEmpty()) {
            return true;
        }

        //logic
        for (int i = 0; i < s.length(); i++) {
            String subStr = s.substring(0, i + 1);

            if(strSet.contains(subStr) && helper(s.substring(i + 1), strSet)) {
                return true;
            }
        }
        return false;
    }
}

//------------------------------------ Solution 3 -----------------------------------
class WordBreak3 {
    /**
     * DP solution using hashmap for memoization. Idea is to persist result of already calculated subproblem result inside
     * map where key is substring and value is boolean true or false.
     *
     * TC: O(n^3 + ml)
     * Auxiliary SC: O(ml + n^2) ml for hashset and n^2 for memo map
     * Recursive stack SC: O(n)
     */
    Map<String, Boolean> memo;
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> strSet = new HashSet<>(wordDict);
        memo = new HashMap<>();
        return helper(s, strSet);
    }

    private boolean helper(String s, Set<String> strSet) {
        //base
        if (memo.containsKey(s)) {
            return memo.get(s);
        }
        if (s.isEmpty()) {
            return true;
        }

        //logic
        for (int i = 0; i < s.length(); i++) {
            String subStr = s.substring(0, i + 1);

            if(strSet.contains(subStr) && helper(s.substring(i + 1), strSet)) {
                memo.put(s, true);
                return true;
            }
        }
        memo.put(s, false);
        return false;
    }
}

//------------------------------------ Solution 4 -----------------------------------
class WordBreak4 {
    /**
     * Bottom up Tabulation DP solution where we start from the smallest possible string from start and check if that
     * can be broken for the dictionary or not and store the result in boolean array. and we expand this string to bigger
     * one. In this bigger one we split string at all possible indices and check left side can be broken or not using previously
     * calculated DP and right side from the wordDict hashset, we only update the DP to true for that bigger string if one of
     * the split is valid wordBreak, otherwise boolean array default false will persist.
     *
     * TC: O(n^3 + ml) n^2 are total iterations and O(n) for string substring
     * SC: O(n + ml) n for dp array and ml for set
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> strSet = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && strSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                }
            }
        }
        return dp[s.length()];
    }
}