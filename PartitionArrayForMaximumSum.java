// Time O(N * K )
// Space O(N) DP space + O(N) Stack space -> O(N)
public class PartitionArrayForMaximumSum {
	int[] dp;
    public int maxSumAfterPartitioning(int[] arr, int k) {
        dp = new int[arr.length];
         return helper(arr,0,k);

    }
    public int helper(int[] arr, int j, int k){
        if(j>=arr.length)
        return 0;
        
        int max=0;
        int len=0;
        int limit = Math.min(arr.length,j+k);
        int maxSum=0;
        if(dp[j]!=0)
        return dp[j];
        else{
            for(int i=j;i<limit;i++){
            len++;
            max = Math.max(max,arr[i]);
            int sum = max * len + helper(arr,i+1,k);
            maxSum = Math.max(sum,maxSum);
        }
        dp[j]= maxSum;
        return maxSum;
        }
        
    }
}
