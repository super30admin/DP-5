// we are attempting to find the array of strings inside the bigger string
// for every word, start a pointer and keep scanning the string
// but that would be an exhuastive search
// what are the constraints?

// tc: O(2^n)  - brute force solution - TLE
// sc: O(1)

// what is my repeated sub problem here that i am attempting to solve?
// if the already traversed part of the string exists in the dictionary don't traverse it again?
// tc: O(n^2) sc: O(n)

class Solution {

  public boolean wordBreak(String s, List<String> wordDict) {
    boolean[] dp = new boolean[s.length() + 1];

    HashSet<String> set = new HashSet<>(wordDict);

    dp[0] = true;

    for (int i = 1; i < dp.length; i++) {
      for (int j = 0; j < i; j++) {
        if (dp[j] && set.contains(s.substring(j, i))) {
          dp[i] = true;
        }
      }
    }

    return dp[dp.length - 1];
  }
}
