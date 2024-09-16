// Time Complexity :O(n^2)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : No
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        
        HashSet<String> set = new HashSet<>();
        for(String word : wordDict){
            set.add(word);
        }
        s= "^" + s;
        boolean[] isValid = new boolean[s.length()];
        isValid[0]=true;
        for(int i=1;i<s.length();i++){
            int k=i;
            while(k>=1){
                if(set.contains(s.substring(k, i+1)) && isValid[k-1]){
                    isValid[i]=true;
                    break;
                }
                k--;
            }
        }
        return isValid[s.length()-1];
    }
}