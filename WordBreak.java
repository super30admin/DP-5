

/**
 * Solves the Word Break problem using BFS by exploring all valid substrings.
 * Utilizes a queue to track start indices and a seen array to avoid reprocessing.
 * Returns true if the end of the string is reachable via valid dictionary words.
 */

//Time Complexity: O(n^2) where n is the length of the string s, as we may check all substrings starting from each index.
//Space Complexity: O(n) for the queue and seen array, where n is the length of the string s.

public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        Queue<Integer> queue = new LinkedList<>();
        Set<String> wordsSet = new HashSet<>(wordDict);
        boolean[] seen = new boolean[s.length() + 1];
        queue.add(0);

        while(!queue.isEmpty()) {
            int start = queue.poll();
            if (start == s.length()) {
                return true;
            }
            for (int end = start + 1; end <=s.length(); end++) {
                if (seen[end]) {
                    continue;
                }
                String subString = s.substring(start, end);
                if (wordsSet.contains(subString)) {
                    queue.add(end);
                    seen[end] = true;
                }
            }
        }

        return false;
    }
}
