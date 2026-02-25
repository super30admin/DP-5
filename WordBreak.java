import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class WordBreak {

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> words = new HashSet<>();
        for (String word : wordDict) {
            words.add(word);
        }

        //  return validWordBreak(s, words, 0);
        return validWordBreak1D(s, words);
    }

    /*
    Time Complexity : O(2^L) L is the average length of the word
    Space Complexity : O(L) in the recursion stack
    Approach :
    With recursion we can find all combination of words in the string, check if the entire word is the dictionary, if yes return true.
    Else create substring such that if the first part is dictionary, check if the rest of the substring is in the word.
    */

    // Recursion
    public boolean validWordBreak(String s, Set<String> words, int pivot) {
        if (pivot == s.length()) return true;

        for (int i = pivot; i < s.length(); i++) {
            String word = s.substring(pivot, i + 1);
            if (words.contains(word) && validWordBreak(s, words, i + 1)) {
                return true;
            }
        }

        return false;
    }

    /*
    Time Complexity : O(L^3) L is the average length of the word - 2 for loop and L for substring
    Space Complexity : O(L) as additional array
    Approach :
    We will memoize the result for character i to true, if there are substrings from 0 to j and j to i position.
    Check if the substring at character j is true, and the rest of string is in the dictionary.
    */
    public boolean validWordBreak1D(String s, Set<String> words) {
        int len = s.length() + 1;
        boolean[] dp = new boolean[len];
        // Empty substring is valid
        dp[0] = true;

        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                String subStr2 = s.substring(j, i);
                // if string before j is true and substring after j is in the dictionary
                if (dp[j] && words.contains(subStr2)) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[len - 1];
    }


}
