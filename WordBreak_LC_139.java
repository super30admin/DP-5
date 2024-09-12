// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : NO
// (https://leetcode.com/problems/word-break/)

// Algo:

/*
 * string: coalerat
 * 
 * dict: cat, bat, coal, ale, c, a, l, co, at, fat, rat}
 * 
 * we can have multiple possibilities to partition and check for in the dictionary -> go exhaustive
 * 
 * f(str)
 * {
 *      for each str we can have partitions from start till n
 *      {
 *          if substring exists in the dictionary, then recursively check for the subsequent string
 *      }
 * }
 * 
 * TC: exponential: O(n^n)
 * SC: O(n)
 * 
 * NOTE: we can store the dictionary words in a Trie to save on space.
 * Check NOTES for tree structure
 */

/*
 * Eg:
 s = "coalerat"

 wordDict = ["a","at","ale","bat","c","co","cat","coal","coale","fat","l","le","rat"]

 output:
 List<List<String>> splitWords = [[co, a, le, rat], [co, ale, rat], [coale, rat]]
 */

/*
 * Repeated sub-problems -> apply DP (memoize)
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak_LC_139 {

    /*
     * TLE
     * 
     * TC: exponential: O(n^n)
     * SC: O(n)
     */
    public boolean wordBreak_recursion(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        return wordBreak_recursion(0, s, dict);
    }

    private boolean wordBreak_recursion(int startIndex, String s, Set<String> wordDict) {
        // base
        if (startIndex == s.length()) {
            return true;
        }
        // logic
        boolean isPossible = false;
        for (int index = startIndex; index < s.length(); index++) {
            String subString = s.substring(startIndex, index + 1);
            if (wordDict.contains(subString)) {
                if (wordBreak_recursion(index + 1, s, wordDict)) {
                    isPossible = true;
                    break;
                }
            }
        }
        return isPossible;
    }

    /*
     * TC: O(n^2) + O(Ns)
     * N = n words in the dictionary
     * s = average length of each word
     * SC: O(2n)
     */
    public boolean wordBreak_memoize(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict); // O(Ns)
        int n = s.length();
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        wordBreak_memoize(0, s, dict, dp);
        return dp[0] == 1 ? true : false;
    }

    private int wordBreak_memoize(int startIndex, String s, Set<String> wordDict, int[] dp) {
        // base
        if (startIndex == s.length()) {
            return 1;
        }
        if (dp[startIndex] != -1) {
            return dp[startIndex];
        }
        // logic
        int isPossible = 0;
        for (int index = startIndex; index < s.length(); index++) {
            String subString = s.substring(startIndex, index + 1);
            if (wordDict.contains(subString)) {
                if (wordBreak_memoize(index + 1, s, wordDict, dp) == 1) {
                    isPossible = 1;
                    break;
                }
            }
        }
        return dp[startIndex] = isPossible;
    }

    /*
     * TC: O(n^2) + O(Ns)
     * N = n words in the dictionary
     * s = average length of each word
     * SC: O(n)
     */
    public boolean wordBreak_tabulate(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict); // O(Ns)
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[n] = 1;

        for (int startIndex = n - 1; startIndex >= 0; startIndex--) {
            int isPossible = 0;
            for (int index = startIndex; index < s.length(); index++) {
                String subString = s.substring(startIndex, index + 1);
                if (dict.contains(subString)) {
                    if (dp[index + 1] == 1) {
                        isPossible = 1;
                        break;
                    }
                }
            }
            dp[startIndex] = isPossible;
        }

        return dp[0] == 1 ? true : false;
    }

    /*
     * TC: O(n^2) + O(Ns)
     * N = n words in the dictionary
     * s = average length of each word
     * SC: O(n)
     */
    public List<String> wordBreak_onePath(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict); // O(Ns)
        int n = s.length();
        int[] dp = new int[n + 1];
        int[] lengths = new int[n];
        dp[n] = 1;

        for (int startIndex = n - 1; startIndex >= 0; startIndex--) {
            int isPossible = 0;
            for (int index = startIndex; index < s.length(); index++) {
                String subString = s.substring(startIndex, index + 1);
                if (dict.contains(subString)) {
                    if (dp[index + 1] == 1) {
                        lengths[startIndex] = index - startIndex + 1;
                        isPossible = 1;
                        break;
                    }
                }
            }
            dp[startIndex] = isPossible;
        }

        List<String> splitWords = new ArrayList<>();

        if (dp[0] != 1) {
            return splitWords;
        }

        for (int i = 0; i < n; i += lengths[i]) {
            String split = s.substring(i, i + lengths[i]);
            splitWords.add(split);
        }

        return splitWords;
    }

    /*
     * TC: O(n^2) + O(Ns)
     * N = n words in the dictionary
     * s = average length of each word
     * SC: O(n)
     */
    public List<List<String>> wordBreak_allPaths(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict); // O(Ns)
        int n = s.length();
        int[] dp = new int[n + 1];
        List<Integer>[] lengths = new ArrayList[n];
        dp[n] = 1;

        for (int startIndex = n - 1; startIndex >= 0; startIndex--) {
            int isPossible = 0;
            for (int index = startIndex, i = 0; index < s.length(); index++) {
                String subString = s.substring(startIndex, index + 1);
                if (dict.contains(subString)) {
                    if (dp[index + 1] == 1) {

                        if (lengths[startIndex] == null) {
                            lengths[startIndex] = new ArrayList<>();
                        }
                        lengths[startIndex].add(index - startIndex + 1);
                        isPossible = 1;
                    }
                }
            }
            dp[startIndex] = isPossible;
        }

        List<List<String>> splitWords = new ArrayList<>();

        if (dp[0] != 1) {
            return splitWords;
        }

        findSplits(splitWords, lengths, 0, new ArrayList<>(), s);

        return splitWords;
    }

    private void findSplits(List<List<String>> splitWords, List<Integer>[] lengths, int index, List<String> curr,
            String s) {
        int n = lengths.length;
        // base
        if (index == n) {
            splitWords.add(new ArrayList<>(curr));
            return;
        }
        int currSize = curr.size();
        // logic
        for (int length : lengths[index]) {
            // action
            String split = s.substring(index, index + length);
            curr.add(split);
            findSplits(splitWords, lengths, index + length, curr, s);
            // backtrack
            curr.remove(currSize);
        }
    }
}
