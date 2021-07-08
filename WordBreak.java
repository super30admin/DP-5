// Time Complexity : O(n^2) in worst case
// Space Complexity : O(n^2)
// Did this code successfully run on Leetcode : Yes. 
// Any problem you faced while coding this : Nope.


// Your code here along with comments explaining your approach
class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
    Set<String> wordDictSet = new HashSet<>(wordDict);
    Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[s.length()];
        q.add(0);
        while(!q.isEmpty()){
            int start = q.poll();
            if(!visited[start]){
                for(int end = start + 1; end <= s.length(); end++){
                    if(wordDictSet.contains(s.substring(start,end))){
                        q.add(end);
                        if(end == s.length()){return true;}
                    }
                }
            visited[start] = true;
            }
        }
    return false;
    }
}