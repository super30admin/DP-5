package dp5;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {
	//Time Complexity : O(n^3), where n is the length of string s
	//Space Complexity : O(n)
	//Did this code successfully run on Leetcode : TLE
	//Any problem you faced while coding this : No
	public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        boolean[] exists = new boolean[s.length() + 1];
        exists[0] = true;
        
        for(int i=1; i<=s.length(); i++) {
            for(int j=0; j<i; j++) {
                if(exists[j] && set.contains(s.substring(j, i))) {
                    exists[i] = true;
                    break;
                }
            }
        }
        return exists[s.length()];
    }
	
	//Time Complexity : O(n^n), where n is the length of string s
	//Space Complexity : O(n)
	//Did this code successfully run on Leetcode : TLE
	//Any problem you faced while coding this : No
	public boolean wordBreak1(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        return recurse(s, set);
    }
    
    private boolean recurse(String s, Set<String> set) {
        // base
        if(s.length() == 0)
            return true;
        
        // logic
        for(int i=0; i<s.length(); i++) {
            if(set.contains(s.substring(0, i + 1)) && recurse(s.substring(i + 1), set))
                return true;
        }
        return false;
    }
}
