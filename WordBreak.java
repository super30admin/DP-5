/*
Time complexity - O((length of string)*(total words in list))
Space Complexity - O(length of string)
*/

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] arr = new boolean[s.length()+1];
        arr[0]=true;
        
        for(int i=0;i<=s.length();i++){
            for(String str:wordDict){
                if(i>=str.length()){
                    if(s.substring(i-str.length(),i).equals(str) && arr[i-str.length()]==true)
                        arr[i]=true;
                }
            }
        }
        
        return arr[s.length()]==true;
    }
}
