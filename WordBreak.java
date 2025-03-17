/*
 * TC: O(n * m) where n is the length of the string and m is the number of words in the dictionary
 * SC: O(n) where n is the length of the string
 */
import java.util.List;

public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s.isEmpty()) return true;
        // dp array
        boolean[] valid = new boolean[s.length() + 1];
        valid[0] = true;
        int i;
        int start = 0;
        for (i = 1; i <= s.length(); i++) {
            // for each word in the dictionary
            for (String word : wordDict) {
                start = i - word.length();
                // check if valid[start] and the substring from start to i equals word,
                // this means that start..i contains a valid word
                if (start >= 0 && valid[start] && word.equals(s.substring(start, i))) {
                    valid[i] = true;
                    break;
                }
            }
        }
        return valid[s.length()];
    }
}