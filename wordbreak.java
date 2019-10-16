//Time complexity: O(N)
//Space complexity: O(N)
//Accepted on leetcode.
//So the aim is to identify if the given string can be broken into valid words (or words present in the given dictionary).
//First I would take a dp array of boolean type with size 1 more than the original string size.
//Also I would take a hashset with all the words in the dictionary to keep track of the words we come across.
//now the 0th place in the dp I would initialize it to True marking the beginning index of our first word.
//Further, We iterate over the given string from the 1st index through the end. And i keep a 'j' index that starts from 1 index lesser than the 'i' and decrement until 0.
//our j is considered the end of the substring and i as the start of the substring.
//at each 'i'th position we check if there are any valid words between j and i index if so we mark the 'i'th index in our dp array as True and break
//after which our j index will be at the place that was last marked True.
//This process is repeated through the end of the string and the last position in the dp array is returned which is the result.
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean [s.length()+1];
        HashSet<String> set = new HashSet<>();
        set.addAll(wordDict);
        
        dp[0] = true;
        for(int i = 1; i<=s.length() ; i++)
        {
          for(int j=i-1; j>=0;j--)  
          {
              dp[i]=dp[j] && set.contains(s.substring(j,i));
              if(dp[i]) break;
              
          }
        }
        return dp[s.length()];
    }
}