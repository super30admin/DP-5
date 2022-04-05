/**


**/

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        
        final Set<String> dictionary = new HashSet<>(wordDict);
        final Queue<Integer> queue = new LinkedList<>();
        final int[] visited = new int[s.length()];
        queue.add(0);
        
        while (!queue.isEmpty())
        {
            int start = queue.remove();
            
            if (visited[start] == 0)
            {
                for (int i=start + 1; i<=s.length(); i++)
                {
                    if (dictionary.contains(s.substring(start, i)))
                    {
                        queue.add(i);
                        if (i == s.length())
                        {
                            return true;
                        }
                    }
                }
                
                visited[start] = 1;
            }
            
            
        }
        
        return false;
    }
}
