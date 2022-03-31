import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/*
Time Complexity: O(n^3) where n is the length of the given string s, recursion size can go up to n^2
Space Complexity: O(n) size of set
Run on leetcode: yes
Any difficulties: no

Approach:
1. I will be using recursion and will be making every possible substring and would try to look for that in the given dict
2. If that exist I am gonna set my memoization state with true other wise false, base condition would be when my index
reaches to the string length
 */
public class WordBreak {
    public static boolean wordBreak(String word, List<String> dictionary){
        return wordBreakRecursion(word,0, new HashSet<>(dictionary), new Boolean[word.length()]);
    }
    public static boolean wordBreakRecursion(String word, int start, HashSet<String> set, Boolean[] memo){
        // base condition
        if(start == word.length()){
            return true;
        }

        if(memo[start]!= null){
            return memo[start];
        }
        // I will start recursion from i+1 because I will be using substring method of string class and
        // that method excludes its close boundary
        for(int i = start+1; i<=word.length(); i++){
            if(set.contains(word.substring(start, i)) && wordBreakRecursion(word, i, set, memo)){
                return memo[start] = true;
            }
        }
        return memo[start] = false;
    }

    public static void main(String[] args){
        List<String> dict = new ArrayList<>();
        dict.add("leet");
        dict.add("code");

        System.out.println("Can we break the given word? "+ wordBreak("leetcode", dict));

        List<String> wordDict = new ArrayList<>();
        wordDict.add("apple");
        wordDict.add("pen");

        System.out.println("Can we break the given word? "+ wordBreak("applepenapple", wordDict));
    }
}
