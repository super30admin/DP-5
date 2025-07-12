// Time complexity - O(n^2)
// Space complexity - O(n)
// solved on leetcode - yes
// faced any issues - no
// Using memo map to store the String and boolean value if it's true or not
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        return helper(s, wordDict, new HashMap<>());
    }

    public boolean helper(String s, List<String> wordDict, Map<String, Boolean> memo) {
        if (s.equals("")) return true;
        if (memo.containsKey(s)) return memo.get(s);

        for (int i = 0; i < s.length(); i++) {
            String p = s.substring(0, i + 1);
            if (wordDict.contains(p)) {
                if (helper(s.substring(i + 1), wordDict, memo)) {
                    memo.put(s, true);
                    return true;
                }
            }
        }

        memo.put(s, false);
        return false;
    }
}
