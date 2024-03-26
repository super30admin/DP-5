
//Tc: O(n^2)
//Sc: O(n)
class Solution {
    private Map<String, Boolean> dp;

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> m = new HashSet<>(wordDict);
        dp = new HashMap<>();
        return helper(s, m);
    }

    public boolean helper(String s, Set<String> m) {
        if (s.length() == 0) {
            return true;
        }
        if (dp.containsKey(s))
            return dp.get(s);
        for (int i = 0; i < s.length(); i++) {
            String r = s.substring(0, i + 1);
            if (m.contains(r)) {
                if (helper(s.substring(i + 1), m)) {
                    dp.put(s, true);
                    return true;
                }
            }
        }
        dp.put(s, false);
        return false;
    }
}