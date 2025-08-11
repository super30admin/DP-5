//time complexity- O(N)
//space complexity- O(N)
import java.util.*;
public class UniquePaths {
    static int uniquePaths(int m, int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for(int i = 0; i < m-1; i++) {
            for(int j = n-2; j >= 0; j--) {
                dp[j] = dp[j+1] + dp[j];
            }
        }
        return dp[0];
    }
    public static void main(String[] args) {
        int m = 3;
        int n = 7;
        System.out.println("Total number of unique paths:" + uniquePaths(m, n));
    }
}
