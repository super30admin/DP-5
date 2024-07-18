import java.util.List;

//time - O(n^3), space - O(n)
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        if(s == null || s.length() == 0) {
            return true;
        }

        boolean[] arr = new boolean[s.length()+1];
        arr[0] = true;
        int j=0;

        for(int i=1; i<arr.length; i++) {
            while(j < i) {
                if(arr[j] == true && wordDict.contains(s.substring(j, i))) {
                    arr[i] = true;
                    j = 0;
                    break;
                } else {
                    j++;
                }
            }
            j=0;
        }

        return arr[arr.length-1];
    }
}