import java.util.*;

public class WordBreakMemoization {

        // Memoization - Dynamic Programming - Time O(N*M*L) + O(M*L) and
        // Space O(M*L) + O(N*N)

        HashSet<String> set;

        HashMap<String, Boolean> map;

        public boolean wordBreak(String s, List<String> wordDict) {

            // store word dictionary in a set for checking substrings
            set = new HashSet<>(wordDict);     // O(m*l)

            // hashmap to map substrings to their booleans
            map = new HashMap<>();

            return memoization(s);
        }

        private boolean memoization(String s) {

            //base
            // whole string s is covered as a successful space-separated sequence of one or more dictionary words
            if(s.length() == 0) return true;

            //logic
            // iteration over string s
            for(int i = 0; i < s.length(); i++) {    // O(n)

                String sub = s.substring(0, i+1);

                // proceed if word dictionary contains substring till iterator-i
                if(set.contains(sub)) {               // O(m)

                    String rest = s.substring(i+1);

                    // add rest of string to map if not there already
                    if(!map.containsKey(rest)) {       // O(l)

                        // call memoization to get boolean value of rest of string
                        boolean restBool = memoization(rest);

                        // pair rest of string and its boolean result
                        map.put(rest, restBool);
                    }

                    // valid sequence if value of rest of string is true
                    if(map.get(rest)) return true;
                }

                //loop continues to explore other children at current pivot
            }
            // if true is not reached inside for loop, there is no valid sequence
            return false;
        }

        public static void main(String[] args) {

            WordBreakMemoization obj = new WordBreakMemoization();

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
TIME COMPLEXITY = O(N*M*L) + O(M*L) = 0(NML)

SPACE COMPLEXITY = O(M*L) + O(N*N)

M = number of words in dictionary
L = average length of word

O(M*L) = storing deep copy of word dictionary hash set

O(N*N) = all possible substrings in hash map

O(N) = recursive stack space

N = length of string s

*/