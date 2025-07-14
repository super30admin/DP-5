import java.util.*;
import java.util.LinkedList;

//Time complexity: O(n^2)
//Space complexity: O(n)

//Intuition: We can use a queue to perform a breadth-first search (BFS) on the string `s`. 
//We start from the beginning of the string and explore all possible substrings that 
//can be formed using words from the dictionary. If we reach the end of the string, we return true. 
// If we exhaust all possibilities without reaching the end, we return false.
public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet<>(wordDict);
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[s.length()];
        queue.add(0);
        while (!queue.isEmpty()) {
            int start = queue.remove();
            if (visited[start]) {
                continue;
            }
            for (int end = start + 1; end <= s.length(); end++) {
                if (wordDictSet.contains(s.substring(start, end))) {
                    if (end == s.length()) {
                        return true;
                    }
                    queue.add(end);
                }
            }
            visited[start] = true;
        }
        return false;
    }
}
