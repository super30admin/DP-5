#  https://leetcode.com/problems/partition-array-for-maximum-sum/   


class Solution:
    def maxSumAfterPartitioning(self, arr: List[int], k: int) -> int:
        n = len(arr)
        self.memo = [-1] * (n)
        return self.helper(arr,0,k,self.memo)

    def helper(self,arr,index,k,memo):
        if index == len(arr):
            return 0
        if memo[index] != -1:
            return memo[index]

        max_val = 0
        maxpart = 0
        for part in range(1,k+1):
            start = index
            end = index + part - 1
            if end == len(arr):
                break
            maxpart = max(maxpart,arr[end])
            max_val = max(max_val, maxpart * part + self.helper(arr,end+1,k,memo))
        memo[index] = max_val
        return max_val

# TC: O(k*n)
# SC: O(n) + rec stack space



class Solution:
    def maxSumAfterPartitioning(self, arr: List[int], k: int) -> int:
        dp = [0] * (len(arr))
        dp[0] = arr[0]

        for i in range(len(arr)):
            max_ans = 0
            for j in range(1,min(k,i+1) +1):
                max_ans = max(max_ans,arr[i-j+1])
                dp[i] = max(dp[i], max_ans * j +( dp[i-j] if i-j >=0  else 0))
        
        return dp[len(arr) - 1]

# TC: O(k*n)
# SC: O(n)