import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
Exaustive Approach:
Consider all possible partitions.
Smallest biggest doesn't matter
"LeetCode" Dictionary = {Leet,Code,Lee,C}
(L, Le, Lee, Leet, LeetC, LeetCo, LeetCod, LeetCode)
If L is there is the dictionary, No don't recur for more, L itself isn't a valid partition
Le isn't there too, we don't look further:
    if Le would have been there, rest of the string would have split into (e,ee,eet,eetC,eetCo,eetCod,eetCode):
        if e would have been there, then for loop based recursion on (e,et,etC,etCo,etCod,etCode)
If by making the partition we reach an empty string, it means we have partitoned this word into valid partiton
if dictionary had {le, e, tco,de}
after le is found then in the same recursion we look for e, e's children will have tco, then tco's children woule hve de
Time complexity: n^n

Repeated Subproblem:
Recursion for Leet, would contain "Code"
If Le is in the Dictionary, it's children et is there, et's children Code is there

*/

/*

During the recursion whatever substring we have created we can look that up in a set of dictionary words.
During the recursion whatever substring we have created we can look that up in a trie of dictionary words.

*/

/*
 DP: Bottom up
 LeetCode, we start from last e
 //it would check in reverse , e then de, then ode, at the end we will be left with 'l'
 //to generalize, at each and every point we are trying to find string before it
 'L', we are trying to find out string before L, can it be split into valid strings
 at each and every character wwe are trying to find string before it is valid or not
 LeetCode,
 1.string before L is empty
 2. at e, what are differnt substrings we can form , would be L
 3. when checking second e, substring would be e and Le, but we have found e from the previous step.
 4. when we are at T, we check substring before it Lee, how it was formed (L, Le, Lee)
 dp[j] = True or false
 tells me if substring before this character was in dictionary or not
 // we move i from the front to find all children in the tree   
 */

public class WordBreak {
    Set<String> set;

    public boolean wordBreak(String s, List<String> wordDict) {
        set = new HashSet<>(wordDict);
        // return helper(s,0);
        return dp(s);
    }

    /*
     * For Loop wih substring
     * public boolean helper(String s)
     * {
     * //base
     * //s has become empty
     * if(s.length()==0)
     * return true;
     * 
     * //logic
     * //have a valid split and try to split the rest of the string to valid splits
     * for(int i=0; i<s.length(); i++)
     * {
     * String substr = s.substring(0,i+1);
     * //we check the initial substring we check if it's inside the dictionary
     * //then only we carry on with the rest of the string
     * if(set.contains(substr) && helper(s.substring(i+1)))
     * {
     * return true;
     * }
     * 
     * }
     * return false;
     * }
     */
    // With pivot
    public boolean helper(String s, int idx) {
        // base
        // s has become empty
        if (idx == s.length())
            return true;

        // logic
        // have a valid split and try to split the rest of the string to valid splits
        for (int i = idx; i < s.length(); i++) {
            String substr = s.substring(idx, i + 1);
            // we check the initial substring we check if it's inside the dictionary
            // then only we carry on with the rest of the string
            // pivot remains at the same place, i moves
            if (set.contains(substr) && helper(s.substring(i + 1), i + 1)) {
                return true;
            }

        }
        return false;
    }

    public boolean dp(String s) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[dp.length - 1];
    }
}
