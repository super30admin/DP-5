import java.util.HashSet;
import java.util.List;

//Time: O(n^3), n^2 for the iteration using two loops and n for the substring function => n^2*n = n^3
//Space: O(n)

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        //we will be making a hashset of the dictionary to compare with substrings we create in the dp solution
        HashSet<String> set = new HashSet<>(wordDict);
        
        //creating the dp array of the size one greater then string length...
        //...as we will be storing the boolean value of a substring on the index following it's end
        boolean [] dp = new boolean [s.length() +1];
        
        //initializing the first value in the dp array as true
        //from the second value onwards, it will represent that the substring of chars before the curr index..
        //..can be segmented into a space-separated sequence of one or more dictionary words as required by the problem
        dp[0] = true;
        
        //now looping through the entire dp array(whose length is one greater than string to accomodate our approach)
        for(int i = 1; i < dp.length; i++) {
            //for each position in the dp array, i also loop over to the ith position to find any space separated sequence until that point
            for(int j = 0; j < i; j++) {
                //if the dp value at jthe index is ture (which means that string from start to j-1 is one of the strings in the dictionary)
                //and if the substring from j to i-1 is also present in the dictionary then we set the dp value of i as true
                if(dp[j] && set.contains(s.substring(j,i))) {
                    dp[i] = true;
                    //we also break the loop as we move forward with our i
                    break;
                }
            }
        }
        //if all the substrings in the dictionary can be made through our string in a space segmented way, our last dp value will be true
        return dp[dp.length - 1];
    }
}