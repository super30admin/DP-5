// Time Complexity : O(N*N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>();
        
        for(String word : wordDict)
            set.add(word);
        
        s="^"+s;
        
        boolean[] isValid = new boolean[s.length()];
        isValid[0]=true;
        
        for(int i=1;i<s.length();i++)
        {
            int k=i;
            while(k >= 1)
            {
                if(set.contains(s.substring(k,i+1)) && isValid[k-1]) {
                    isValid[i]=true;
                    break;
                }
                k--;
            }
        }
        return isValid[s.length()-1];
    }
}
