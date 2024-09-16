import java.util.Scanner;
public class UniquePathsRobotMemoization {

        // DYNAMIC PROGRAMMING - MEMOIZATION - O(M*N) TIME AND O(M*N) SPACE

        // in memoization, usage of data structure can be flexible
        // whereas in bottom-up, the same given data structure is used
        int[][] memo;

        public int uniquePaths(int m, int n) {

            // memoization
            memo = new int[m][n];

            // start from top-left
            return memoization(0, 0, m, n);
        }

        private int memoization(int i, int j, int m, int n) {

            //base
            // if bottom-right is reached
            if(i == m-1 && j == n-1)    return 1;

            //logic
            int right = 0;

            // right movement within bounds
            if(j+1 < n) {

                // unreached memoization grid location
                if(memo[i][j+1] == 0) {

                    // make dp call and fill in
                    memo[i][j+1] = memoization(i, j+1, m, n);
                }

                // count in existing memoization value
                right = memo[i][j+1];
            }

            int down = 0;

            //down movement within bounds
            if(i+1 < m) {

                // unreached memoization grid location
                if(memo[i+1][j] == 0) {

                    // make dp call and fill in
                    memo[i+1][j] = memoization(i+1, j, m, n);
                }

                // count in existing memoization value
                down = memo[i+1][j];
            }

            // number of ways from both movements
            return down + right;
        }

        public static void main(String[] args) {

            UniquePathsRobotMemoization obj = new UniquePathsRobotMemoization();

            Scanner scanner = new Scanner(System.in);

            System.out.println("m: ");
            int m = scanner.nextInt();

            System.out.println("n: ");
            int n = scanner.nextInt();

            int answer = obj.uniquePaths(m, n);

            System.out.println("the number of possible unique paths that the " +
                    "robot can take to reach the bottom-right corner from top-left start is " + answer);
        }

}


/*
TIME COMPLEXITY =  O(M*N)

time to reach all nodes in grid once = O(M*N)

SPACE COMPLEXITY = O(M*N)

memoization grid space = O(M*N)
recursive stack space  = O(M*N)
*/