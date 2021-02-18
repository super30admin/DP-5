// Time Complexity : O(n3 (cube)) n = length of str
// Space Complexity : O(n) for array 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


//Your code here along with comments explaining your approach
// Dynamic Programming approach
// At each index we check if the string before it has a valid split or not.
//Maintain a HashSet for  dict

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {


        HashSet<String> set = new HashSet();
        set.addAll(wordDict);

        boolean[] dpArray = new boolean[s.length()+1];
        dpArray[0] = true;
        for(int i = 1; i < dpArray.length; i++) {
            for (int j = 0; j < i; j++) {
                if(dpArray[j]) {
                    if(set.contains(s.substring(j,i))) {
                        dpArray[i] = true;
                        break;
                    } else {
                        dpArray[i] = false;
                    }
                } else {
                    dpArray[i] = false;
                }
            }
        }

        return dpArray[s.length()];
    }
}
