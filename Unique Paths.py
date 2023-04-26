class Solution:
    # Time Complexity: O(m*n)
    # Space Complexity: O(n)
    def uniquePaths(self, m: int, n: int) -> int:
        memoize = [1 for i in range(n)]
        # print(memoize)
        for i in range(m - 1):
            for j in range(n - 2, -1, -1):
                memoize[j] += memoize[j + 1]

            # print(memoize)
        return memoize[0]