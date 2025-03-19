// Problem2: (https://leetcode.com/problems/partition-array-for-maximum-sum/description/)

// Time Complexity : O(3^n) 
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach in three sentences only
/*
 * Here, take a dp array of length arrays length and fill dp[0] with arr[0] and traverse from 1 to arr.length and from k=1 to 3 and also
 * check in k loop if i-j+1>0. Update dp[i] with max(dp[i] and max*j+dp[i-j]) if i-j>=0 else max(dp[i] and max*j). Finally return dp[arr.length-1].
 */
// 1
class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        return helper(arr, 0, k); // 0 is pivot
    }
    private int helper(int[] arr, int pivot, int k){
        // base case
        if(pivot == arr.length) return 0;
        int max = 0;
        int result = 0;
        for(int i = pivot; i < pivot+k && i<arr.length;i++){
                max = Math.max(max, arr[i]);
                int curr = max * (i-pivot+1); 
                int rest = helper(arr, i+1, k);
                result = Math.max(result, curr + rest);
        }
        return result;
    }
}
// 2
class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int []memo = new int[arr.length];
        Arrays.fill(memo, -1);
        return helper(arr, 0, k, memo); // 0 is pivot
    }
    private int helper(int[] arr, int pivot, int k, int []memo){
        // base case
        if(pivot == arr.length) return 0;
        if(memo[pivot] != -1) return memo[pivot];
        int max = 0;
        int result = 0;
        for(int i = pivot; i < pivot+k && i<arr.length;i++){
                max = Math.max(max, arr[i]);
                int curr = max * (i-pivot+1); 
                int rest = helper(arr, i+1, k, memo);
                result = Math.max(result, curr + rest);
        }
        memo[pivot] = result;
        return result;
    }
}
// 3
class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int []dp = new int[arr.length];
        dp[0] = arr[0];
        
        for(int i = 1; i< arr.length;i++){
            int max = 0;
            for(int j = 1; j<=k && (i-j+1)>=0; j++){
                max = Math.max(max, arr[i-j+1]);
                if(i-j < 0){
                    dp[i] = Math.max(dp[i], max * j);
                }
                else{
                    dp[i] = Math.max(dp[i], max * j + dp[i-j]);
                }
            }
        }
        return dp[arr.length-1];  
    }
}