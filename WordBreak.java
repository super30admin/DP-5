// Time Complexity: O(n^2) - outer loop O(n)
// Inner loop n(n+1)/2 - O(n^2).
// substring operation is O(1) due to string optimisation in java , Set Loopkup is O(1)
// So overall time complexity is o(N^2)

// Space Complexity: O(n) : dp array O(n)
//Set Storage O(m.k) , m words in dict , k substring. Substring storage does not require extra space due to string optimisation in java

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {
public static boolean wordBreak(String s, List<String> wordDict){
    Set<String> wordSet = new HashSet<>(wordDict);
    int n = s.length();
    boolean [] dp = new boolean [n + 1];
    dp[0] = true; // base case: Empty substring can always be segmented

    for(int i = 1; i <=n; i++){
        for (int j =0; j <i; j++){
            if(dp[j] && wordSet.contains(s.substring(j,i))){
                dp[i] = true;
                break;
            }
        }
    }
    return dp[n];
}

public static void main (String[] args){
    // Example 1
    String s1 = "leetcode";
    List<String> wordDict1 = Arrays.asList("leet", "code");
    System.out.println("Output: " + wordBreak(s1, wordDict1)); // Output: true

    // Example 2
    String s2 = "applepenapple";
    List<String> wordDict2 = Arrays.asList("apple", "pen");
    System.out.println("Output: " + wordBreak(s2, wordDict2)); // Output: true

    // Example 3
    String s3 = "catsandog";
    List<String> wordDict3 = Arrays.asList("cats", "dog", "sand", "and", "cat");
    System.out.println("Output: " + wordBreak(s3, wordDict3)); // Output: false
}
}
