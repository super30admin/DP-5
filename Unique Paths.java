class Solution {
    public int uniquePaths(int m, int n) {
        
        double result = 1;

        // Choose minimum number of steps between m - 1 and n - 1 because calculating the fact would be easy
        int min = Math.min(m - 1, n - 1);

        for(int i = 1; i <= min; i++)
        {
            // For example we start at m + n - 2 the value is 5, then it become 4, 3, ....
            result = result * (m + n - 1 - i);

            result /= i;
        }

        return (int) result;
    }
}