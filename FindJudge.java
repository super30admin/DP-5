// Problem 997. Find the Town Judge
// Time Complexity : O(n+t)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
class Solution {
    public int findJudge(int n, int[][] trust) {
        if (n == 1) return 1;
        int[] trustCount = new int[n + 1];
        int[] trusts = new int[n + 1];
        for (int[] relation : trust) {
            int a = relation[0];
            int b = relation[1];
            trusts[a]++;
            trustCount[b]++;
        }
        for (int i = 1; i <= n; i++) {
            if (trustCount[i] == n - 1 && trusts[i] == 0) {
                return i;  // This person is the judge
            }
        }
        return -1;
    }
}
