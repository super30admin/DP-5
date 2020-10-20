import java.util.HashMap;
import java.util.List;

/* 139. Word Break - MEDIUM

Approach: Recursive approach
Iterate through all the words in the dictionary. If the string starts with a word in the dictionary,
then the next sub-problem is to check if the remaining part of the string can be formed with the words in the dictionary.

TC: O()
SC: O(n) - length of string, maximum elements in the stack will be when the word in dictionary is of single character and it matches.
*/

public class WordBreak {
    HashMap<String, Boolean> dp = new HashMap<>();
    
    public boolean wordBreak(String s, List<String> wordDict) {    
        if (s == null || s.length() == 0 || wordDict == null || wordDict.size() == 0) {
            return false;
        }        
        for (String st: wordDict) {
            dp.put(st, true);
        }        
        return helper(s, wordDict);
    }
    
    private boolean helper(String s, List<String> wordDict) {
        if (s.length() == 0) {
            return true;
        }
        
        if (dp.containsKey(s)) {
            return dp.get(s);
        }
        
        for (int i = 0; i < wordDict.size(); i++) {
            if (s.length() >= wordDict.get(i).length()) {
                String prefix = s.substring(0, wordDict.get(i).length());
                String rem = s.substring(wordDict.get(i).length(), s.length());
                
                if (prefix.equals(wordDict.get(i)) && helper(rem, wordDict)) {
                    dp.put(s, true);
                    return true;
                }
            }
        }
        dp.put(s, false);
        return false;
    }
}
