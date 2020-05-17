/**
 * Time Complexity - O(n^2)
 * Space Complexity - O(n)
 */


class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>();

        for(String str : wordDict){
            set.add(str);
        }
        // return wordBreakRecursion(s,set,0, new Boolean[s.length()]);
        return wordBreakDP(s,set);

    }


    private boolean wordBreakRecursion(String s, Set<String> wordDict, int start, Boolean[] memo){

        // base condition
        if(start == s.length())
            return true;

        if(memo[start] != null)
            return memo[start];

        for(int end = start; end <= s.length(); end++){
            if(wordDict.contains(s.substring(start,end)) && wordBreakRecursion(s,wordDict,end,memo)){
                return memo[start] = true;
            }
        }
        return memo[start] = false;
    }

    private boolean wordBreakDP(String s, Set<String> wordDict){

        boolean[] visited = new boolean[s.length()+1];

        visited[0] = true;

        for(int end=1; end <= s.length(); end++){

            for(int start=0; start < end; start++){

                if(visited[start] && wordDict.contains(s.substring(start,end))){
                    visited[end]= true;
                    break;
                }
            }
        }

        return visited[s.length()];
    }
}