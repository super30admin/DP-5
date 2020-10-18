//TC: O(n2) since we are iterating n times in the main function and recursing n times in the helper
// SC: O(n) creation of array

import java.util.*;

public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] arr = new boolean[s.length()+1];
        // seeting true just to consider the empty string
        arr[0] = true;
        // iterating through the index 1 untill the array length 
        for(int i=1; i<arr.length; i++){
            helper(s, wordDict, i, arr);
        }
        return arr[arr.length-1];
    }
    
    public void helper(String s, List<String> list, int start, boolean[] arr) {

        for(int i=0; i<start; i++){
            // checking if the substring is present in the list if yes set the start index to "true"
            if(arr[i] && list.contains(s.substring(i, start))){
                arr[start] = true;
            }
        }
    }
}