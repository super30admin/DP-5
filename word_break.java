// Time Complexity :n^4 if we consider that set will take O(n) to check contains
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes

class Solution {

    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>();
        int strLen = s.length();
        boolean[] result = new boolean[strLen + 1];
        for (String word : wordDict) {
            set.add(word);
        }
        result[0] = true;
        for (int i = 1; i < result.length; i++) {
            for (int j = 0; j < i; j++) {
                if (result[j]) {
                    String sub = s.substring(j, i);
                    if (set.contains(sub)) {
                        result[i] = true;
                    }
                }
            }
        }
        return result[strLen];
    }

}