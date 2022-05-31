// Time Complexity : O(n^3)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// Your code here along with comments explaining your approach: check if substrings of the word s can be constructed from the the wordDict

public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        Map<String, Boolean> map = new HashMap<>();
        return canConstruct(s, wordDict, map);
    }

    private boolean canConstruct(String s, List<String> wordDict, Map<String, Boolean> map) {
        // s is already in the map
        if (map.containsKey(s))
            return map.get(s);
        // base - s is empty
        if (s.isEmpty())
            return true;

        // if s contains first part in dict
        for (String str : wordDict) {
            // and second part can be constructed
            if (s.startsWith(str) && canConstruct(s.substring(str.length()), wordDict, map)) {
                map.put(s, true);
                return true;
            }
        }
        // s cannot be constructed with words in dict
        map.put(s, false);
        return false;
    }
}
