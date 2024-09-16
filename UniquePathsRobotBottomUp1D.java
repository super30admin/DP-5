import java.util.Scanner;

public class UniquePathsRobotBottomUp1D {

        // DYNAMIC PROGRAMMING - BOTTOM UP 1D - O(M*N) TIME AND O(N) SPACE

        public int uniquePaths(int m, int n) {

            // bottom up dp tabulation with extra dummy rightmost column
            int[] bottomUp = new int[n+1];       // O(N) space

            // bottom-right spot can be reached
            bottomUp[n-1] = 1;

            // build bottom up dp tabulation
            for(int i = m-1; i >= 0; i--) {      // O(M*N)

                // can start from n-2 column as the last but n-1 column will always be one
                for(int j = n-2; j >= 0; j--) {

                    // below sum rule won't at destination which can't be zero
                    if(i == m-1 && j == n-1) continue;

                    // down == bottomUp[i+1][j]
                    int down = bottomUp[j];

                    // current dp value is sum of down and right dp values
                    bottomUp[j] =  down + bottomUp[j+1];
                }
            }
            // output number of ways at start
            return bottomUp[0];
        }

        public static void main(String[] args) {

            UniquePathsRobotBottomUp1D obj = new UniquePathsRobotBottomUp1D();

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

SPACE COMPLEXITY = O(N)

memoization dp tabulation array space = O(N)
recursive stack space  = O(N)

N = number of columns
*/

