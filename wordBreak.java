// Time Complexity : O(n*n*n)
// Space Complexity : O(n) 
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO

// Your code here along with comments explaining your approach
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        
        Set<String> set = new HashSet(wordDict);
        Queue<Integer> q = new LinkedList();
        boolean[] vis = new boolean[s.length()];
        q.add(0);
        
        while(!q.isEmpty()) {
            
            int left = q.poll();
            if(vis[left]) continue;
            vis[left] = true;
            for(int i = left+1; i<=s.length(); i++) {
                
                String curr = s.substring(left,i);
                
                if(set.contains(curr)) {
                    q.add(i);
                    if(i == s.length()) {
                        return true;
                    }
                }
                
            }
            
        }
        
        return false;        
    }
}
