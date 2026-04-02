// Time Complexity : O(n^2)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
/*
First, we convert word dictionary to set for faster search. Next, we have a helper method to generate substrings
by having partitions recursively using for based loop until string length and check if the substring appears in
the set.If so, recurse further to check the remaining formed substrings.At any point, if we reach till the end of
the string, we return true. To optimize the speed and not solve repeated subproblems again, we have a Boolean
array to memoize the solved substrings' value(true or false) by using pivot index.
 */
class Solution {
    Set<String> set;
    Boolean memo[];
    public boolean wordBreak(String s, List<String> wordDict) {
        this.set = new HashSet<>(wordDict);
        this.memo = new Boolean[s.length()];
        return helper(s, 0);
    }

    private boolean helper(String s, int pivot) {
        if(pivot == s.length())
            return true;

        if(memo[pivot] != null)
            return false;

        for(int i = pivot ; i < s.length() ; i++) {
            String subStr = s.substring(pivot, i + 1);
            if(set.contains(subStr)) {
                if(helper(s, i + 1))
                    return true;
            }
        }
        memo[pivot] = false;
        return false;
    }
}