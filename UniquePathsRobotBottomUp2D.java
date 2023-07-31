import java.util.Scanner;
public class UniquePathsRobotBottomUp2D {

        // DYNAMIC PROGRAMMING - BOTTOM UP - O(M*N) TIME AND O(M*N) SPACE

        public int uniquePaths(int m, int n) {

            // bottom up dp tabulation with extra dummy last column and last row
            int[][] bottomUp = new int[m+1][n+1];

            // bottom-right spot can be reached
            bottomUp[m-1][n-1] = 1;

            // build bottom up dp tabulation
            for(int i = m-1; i >= 0; i--) {

                for(int j = n-1; j >= 0; j--) {

                    // below sum rule won't at destination which can't be zero
                    if(i == m-1 && j == n-1) continue;

                    // current dp value is sum of down and right dp values
                    bottomUp[i][j] = bottomUp[i+1][j] + bottomUp[i][j+1];
                }
            }
            // output number of ways at start
            return bottomUp[0][0];
        }

        public static void main(String[] args) {

            UniquePathsRobotBottomUp2D obj = new UniquePathsRobotBottomUp2D();

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
recursive stack space  = O(M+N)
*/