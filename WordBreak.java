import java.util.HashSet;
import java.util.List;

//for-loop based recursion
public class WordBreak {
    HashSet<String> set;
    HashSet<String> memo; // tracks strings not found in dict

    public boolean wordBreak(String s, List<String> wordDict) {
        this.set = new HashSet<>(wordDict);
        this.memo = new HashSet<>();
        return helper(s, 0);
    }

    private boolean helper(String s, int pivot) {
        if (pivot == s.length()) {
            return true;
        }

        if (memo.contains(s.substring(pivot, s.length()))) {
            return false;
        }

        for (int i = pivot; i < s.length(); i++) {
            String substring = s.substring(pivot, i + 1);
            if (set.contains(substring)) {
                if (helper(s, i + 1)) {
                    return true;
                }
            }
        }

        memo.add(s.substring(pivot, s.length()));

        return false;
    }
}


//TC: O(l^3), SC: O(n + dictSet);
