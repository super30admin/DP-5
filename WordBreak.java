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

    /*
    TC: O(n^2 * n) - for 2 loops aand generating substring
    SC: O(n) - for dp array and hashset
    */
    public boolean wordBreakDP(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>();
        if (s == null || s.length() == 0 || wordDict == null || wordDict.size() == 0) {
            return false;
        } 
        
        for (String word: wordDict) {
            set.add(word);
        }
        
        boolean[] dp = new boolean[s.length() + 1];
        
        // empty string can be constructed using words in dict
        dp[0] = true;
        
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] == true && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                    // important to break here, as we have a valid break at this point
                    break;
                }
            }
        }
        
        return dp[dp.length - 1];
    }
}
