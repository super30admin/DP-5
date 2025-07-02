class Solution {
    public int uniquePaths(int m, int n) {
        Map<String, Integer> memo = new HashMap<>();
        return dfs(m, n, memo);
    }

    private int dfs(int m, int n, Map<String, Integer> memo) {
        if (m == 0 || n == 0) return 0;
        if (m == 1 && n == 1) return 1;

        String key = m + "," + n;
        if (memo.containsKey(key)) return memo.get(key);

        int down = dfs(m - 1, n, memo);
        int right = dfs(m, n - 1, memo);

        memo.put(key, down + right);
        return down + right;
    }
}
