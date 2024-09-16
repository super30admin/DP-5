import java.util.Scanner;
public class UniquePathsRobotExhaustiveRecursion {

        // BRUTE FORCE - EXHAUSTIVE RECURSION -  O(2^(M*N)) TIME AND O(M+N) SPACE

        public int uniquePaths(int m, int n) {

            // start from top-left
            return recursion(0, 0, m, n);
        }

        private int recursion(int i, int j, int m, int n) {

            //base
            if(i == m || j == n)        return 0;

            // if bottom-right is reached
            if(i == m-1 && j == n-1)    return 1;

            //logic
            // down
            int down = recursion(i + 1, j, m, n);

            // right
            int right = recursion(i, j + 1, m, n);

            // number of ways from both movements
            return down + right;
        }

        public static void main(String[] args) {

            UniquePathsRobotExhaustiveRecursion obj = new UniquePathsRobotExhaustiveRecursion();

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
TIME COMPLEXITY =  O(2^(M*N))

two recursion choices at each element of m*n grid

SPACE COMPLEXITY = O(M+N)

recursive stack  space
*/