//Brute-force , exhausted
//for loop recursion
//exhaustive approach
//generate all combination and look for their sub problems
//tc : n^n
//sc: n^n

class Solution {
    Set<String> set;

    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || wordDict == null)
            return false;

        set = new HashSet<>(wordDict);

        return helper(s);
    }

    private boolean helper(String s) {
        // base case
        if (s.length() == 0)
            return true;

        // for loop
        for (int i = 0; i <= s.length(); i++) // make sure we do <= as we're taking substring, if just '<' thn ast
                                              // character will be missed; we cn start i at 0 or 1 ; but if we start at
                                              // 0 the substring willbe empty. so better to start at 1.
        {
            String substr = s.substring(0, i);
            if (set.contains(substr)) {
                // generate sub problems for that sub string ; we found "L"; now looking for
                // e,ee,eet etcetra
                if (helper(s.substring(i)))
                    return true;

                // else continue, i increments, and we explore other substring in main for loop
            }
        }

        // if never returned
        return false;
    }
}

// we find repeated subproblems here, so we can minimize that using DP.

// approach
/*
 * avoid repeated subproblems with DP - memoization technique
 * take a dp array of stringlen+1
 * if substring combination is in the set, we mark the i index as true
 * meanwhile, i keeps moving to end, and every time i increments, j resets to
 * zero
 * TC: O(n^2) two for loops running hand in hand * O(n) substing geneartion +
 * O(n) generating hash for lookup
 * TC: O(n^3)
 * SC:O(n) - dp array + Set
 * 
 */

class Solution {
    Set<String> set;

    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || s.length() == 0)
            return true;

        set = new HashSet<>(wordDict);

        boolean[] dp = new boolean[s.length() + 1];

        // "_ L E E T C O D E"
        // { , , , , , , , }

        // y default boolean array is false
        // base case is we consder first string as ""
        // set.add(""); for index =-1 we have string as ""; and for that 0 will be
        // marked as true
        dp[0] = true;

        for (int i = 0; i < dp.length; i++) {
            // j moves to i
            for (int j = 0; j < i; j++) {
                if (dp[j] == true) {
                    String substr = s.substring(j, i);

                    if (set.contains(substr))
                        dp[i] = true;
                }
            }
            // when we et out of j loop, i increments, and for next execution of j's for
            // loop j starts from 0
        }
        return dp[dp.length - 1];
    }
}
