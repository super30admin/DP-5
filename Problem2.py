class Solution:
    def maxSumAfterPartitioning(self, arr: List[int], k: int) -> int:
        n = len(arr)
        dp = [0] * n
        
        for i in range(n):
            tmax = 0
            for j in range(1, min(k, i+1) + 1):

                tmax = max(tmax, arr[i - j + 1])
            
                if i - j >= 0:
                    dp[i] = max(dp[i], dp[i - j] + tmax * j)
                else:
                    dp[i] = max(dp[i], tmax * j)
                    
        return dp[n - 1]
