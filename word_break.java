class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        if(s == null || s.length() == 0) return true; //if the string s is null or the length of the string s is 0 we return true
        HashSet<String> set = new HashSet<>(wordDict); // we create a hashset which has string as the input with name set and with name as set and to this hashset we give store the elements we have in wordDict of the list of strings.
        boolean[] dp = new boolean[s.length() + 1]; //we create a boolean array with name as dp of length as s.length + 1
        dp[0] = true; // we mark the first index of the dp array as true. which means that the elements that are present before the 0th index are considered to be present in the hashset. basically there are no elements before the 0th index
        for(int i = 1; i <= s.length(); i++) { //we iterate through all the elements present in the array of string s starting from index 1
            for(int j = 0; j < i; j++) { // we have another pointer which is initially pointed to 0 and can iterate only until i.
                if(dp[j] == true) { //if the value at location j is true, which it actually is initially,
                    if(set.contains(s.substring(j, i))) { // we check if the set contains the substring in string s from j to i.
                        dp[i] = true; // if so, we return true at index of i
                    }
                }
            }
        }
        return dp[s.length()]; // in the end, we return the value at dp[s.length];
    }
}
//tc and sc - O(n ^ 4) and O(n)