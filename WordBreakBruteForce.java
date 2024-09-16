import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
public class WordBreakBruteForce {

        // Brute Force - Exhaustive Recursion - O(N^N) Time and O(M*L) + O(N) Space

        HashSet<String> set;

        public boolean wordBreak(String s, List<String> wordDict) {

            // store word dictionary in a set for checking substrings
            set = new HashSet<>(wordDict);     //O(m*l)

            return recursion(s);
        }

        private boolean recursion(String s) {

            //base
            // whole string s is covered as a successful space-separated sequence of one or more dictionary words
            if(s.length() == 0) return true;

            //logic
            // iteration over string s
            for(int i = 0; i < s.length(); i++) {       // O(N^N)

                String sub = s.substring(0, i+1);

                // recurse only if substring till iterator-i is in set of word dictionary
                if(set.contains(sub) && recursion(s.substring(i+1))) {

                    // return true if recursion on remaining substring is valid
                    return true;
                }
            }
            // if true is not reached inside for loop, there is no valid sequence
            return false;
        }

        public static void main(String[] args) {

            WordBreakBruteForce obj = new WordBreakBruteForce();

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
TIME COMPLEXITY = O(N^N)

SPACE COMPLEXITY = O(M*L) + O(N)

M = number of words in dictionary
L = average length of word

N = length of string s

recursive stack space = O(N)
*/