/*
We will try to solve the sub problems first , the technique is that to find the valid splits

If s is the length of the string, w is the number of words and l is the length of the longest string in words then:
Time: O(w*l) + O(s^3)
Space : O(w*l) + O(s)
*/
class Solution {

    public boolean wordBreak(String s, List<String> wordDict) {

        HashSet<String> set = new HashSet<String>();
        // we will put the list of string in the set

        for(String str: wordDict){ // O(w)
            set.add(str); //O(l)
        }

        boolean dp[] = new boolean[s.length()+1]; // at each index, we will store whether a valid substring can be found or not before it
        dp[0] = true;  // before 0 is empty string, and we will consider it as valid

        for(int i=1;i<=s.length();i++){ // O(s)
            for(int j=0;j<i; j++){ // O(s)
                // we will check if there is a valid string till J, if there is we will check if there is a valid string can be found from j to i, if so then we will mark dp
                 if(dp[j]){
                    if(set.contains(s.substring(j,i))){ // O(s)
                        dp[i] = true; 
                    }
                }
            }
        }

        return dp[s.length()];
    }


}