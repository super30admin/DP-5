// Time Complexity : O(n*n) where n = length of string
// Space Complexity : O(l) + O(n) where l = length of list, n = length of string
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
//139. Word Break (Medium) - https://leetcode.com/problems/word-break/
//class Solution {
//    
//    HashSet<String> set;
//    
//    public boolean wordBreak(String s, List<String> wordDict) {
//       set  = new HashSet<>(wordDict);
//        return helper(s);
//    }
//    
//    private boolean helper(String s) {
//        // base
//        if (s.length() == 0) return true;
//        
//        // logic
//        for (int i = 0; i < s.length(); i++) {
//            String subStr = s.substring(0, i+1);
//            if (set.contains(subStr) && helper(s.substring(i+1))) {
//                return true;
//            }
//        }
//        
//        return false;
//    }
//}

//class Solution {
//    
//    HashSet<String> set;
//    
//    public boolean wordBreak(String s, List<String> wordDict) {
//       set  = new HashSet<>(wordDict);
//        return helper(s, 0);
//    }
//    
//    private boolean helper(String s, int pivot) {
//        // base
//        if (pivot == s.length()) return true;
//        
//        // logic
//        for (int i = pivot; i < s.length(); i++) {
//            String subStr = s.substring(pivot, i+1);
//            if (set.contains(subStr) && helper(s, i+1)) {
//                return true;
//            }
//        }
//        
//        return false;
//    }
//}

class Solution {

	public boolean wordBreak(String s, List<String> wordDict) {
		HashSet<String> set = new HashSet<>(wordDict);
		boolean[] dp = new boolean[s.length() + 1];
		dp[0] = true;

		for (int i = 1; i < dp.length; i++) {
			for (int j = 0; j < i; j++) {
				if (dp[j] && set.contains(s.substring(j, i))) { // if valid split, then take substring and check for
																// that substring in set, if
					// yes then mark current dp[i] as true
					dp[i] = true;
					break;
				}
			}
		}

		return dp[dp.length - 1];
	}
}