import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.util.Scanner;

public class WordBreakBottomUp {

        // BOTTOM-UP DYNAMIC PROGRAMMING - TIME O(N*M*L) + O(M*L) AND SPACE O(N) + O(M*L)

        public boolean wordBreak(String s, List<String> wordDict) {

            // store word dictionary in a set for checking substrings
            HashSet<String> set = new HashSet<>(wordDict);     // O(m*l)

            boolean[] dp = new boolean[s.length()+1];

            dp[0] = true;                              // O(n) space

            // build bottom up dp array
            for(int i = 1; i < dp.length; i++) {      // O(n)

                // if dp[j] is true, previous sub string is valid. So check rest of sub string till iterator-i
                for(int j = 0; j < i; j++) {         // O(m*l)

                    if(dp[j] && set.contains(s.substring(j, i))) {

                        dp[i] = true;

                        break;
                    }
                }
            }
            //
            return dp[s.length()];
        }

        public static void main(String[] args) {

            WordBreakBottomUp obj = new WordBreakBottomUp();

            Scanner scanner = new Scanner(System.in);

            System.out.print("string s: ");
            String s = scanner.nextLine();

            System.out.print("word dictionary size: ");
            int l = scanner.nextInt();
            scanner.nextLine();

            System.out.print("word dictionary: ");
            List<String> wordDict = new ArrayList<>();

            for (int i = 0; i < l; i++) {

                String word = scanner.nextLine();
                wordDict.add(word);
            }

            boolean answer = obj.wordBreak(s, wordDict);

            System.out.print("Can string s be segmented into a space-separated sequence of one " +
                    "or more dictionary words? " + answer);
        }

}


/*
TIME COMPLEXITY = O(N*M*L) + O(M*L)

SPACE COMPLEXITY = O(N) + O(M*L)
*/