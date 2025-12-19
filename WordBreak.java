class Solution {
    Set<String> dictSet;

    // DP - Expected method 
    // SC for set - if m words in dict and k is avg len, then mk plus we use boolean array.
    // total SC O(mk) + O(n)
    public boolean wordBreakDP(String s, List<String> wordDict) {
        if (s == null || s.length() == 0) {
            return true;
        }

        if (wordDict.size() == 0) {
            return false;
        }

        dictSet = new HashSet<>(wordDict);

        int n = s.length();
        // boolean dp[] = new boolean[n + 1];
        // dp[0] = true;
        // // l e e t c o d e
        // // 0 1 2 3 4 5 6 7
        // for (int i = 0; i < n; ++i) {
        //     for (int j = i; j >= 0; --j) {
        //         // System.out.println
        //         if ((j == 0 || dp[j]) && dictSet.contains(s.substring(j, i + 1))) {
        //             dp[i + 1] = true;
        //             break;
        //         }
        //     }
        // }
        // return dp[n];

        // similar but j loop different
        boolean dp[] = new boolean[n];
        // l e e t c o d e
        // 0 1 2 3 4 5 6 7
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j <= i; ++j) {
                // System.out.println
                if ((j == 0 || dp[j - 1]) && dictSet.contains(s.substring(j, i + 1))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n - 1];


    }


    // TLE for recursion method
    public boolean wordBreakRecurse(String s, List<String> wordDict) {
        if (s == null || s.length() == 0) {
            return true;
        }

        if (wordDict.size() == 0) {
            return false;
        }

        dictSet = new HashSet<>(wordDict);
        return recurse(s);
    }

    private boolean recurse(String s) {
        if (s.length() == 0) {
            return true;
        }

        for (int i = 0; i < s.length(); ++i) {
            if (dictSet.contains(s.substring(0, i + 1)) && recurse(s.substring(i + 1))) {
                return true;
            }
        }
        return false;
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || s.length() == 0) {
            return true;
        }

        if (wordDict.size() == 0) {
            return false;
        }

        dictSet = new HashSet<>(wordDict);

        // Map<String, Boolean> memo = new HashMap<>();
        // return recurseMemoString(s, memo);

        Map<Integer, Boolean> memoIndex = new HashMap<>();
        return recurseMemoIndex(s, 0, memoIndex);
    }

    private boolean recurseMemoIndex(String s, int start, Map<Integer, Boolean> memo) {
        if (start == s.length()) {
            return true;
        }

        if (memo.containsKey(start)) {
            return memo.get(start);
        }

        for (int i = start; i < s.length(); ++i) {
            if (dictSet.contains(s.substring(start, i + 1)) && recurseMemoIndex(s, i + 1, memo)) {
                memo.put(start, true);
                return true;
            }
        }
        
        memo.put(start, false);
        return false;
    }

    private boolean recurseMemoString(String s, Map<String, Boolean> memo) {
        if (s.length() == 0) {
            return true;
        }

        if (memo.containsKey(s)) {
            return memo.get(s);
        }

        for (int i = 0; i < s.length(); ++i) {
            if (dictSet.contains(s.substring(0, i + 1)) && recurseMemoString(s.substring(i + 1), memo)) {
                memo.put(s, true);
                return true;
            }
        }
        
        memo.put(s, false);
        return false;
    }
}