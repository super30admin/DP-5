/*
* Approach 1: DFS + memoization -> top down dp
    - At every character we have the option to either split or not split so its an exhaustive approach. 
        - if the split exists in the dictionary, then it makes sense to go ahead and split
        - once the split is made and substring is not valid, we can store it in a map to so that we dont have to process the substring all over again
TC: O(n^2) -> loop through the string and substring creation(amortized) -> technically it is n^3 -> but memoization and early exist makes it n^2
SC: O(n^2) -> recursive stack space and map space
 */
class Solution {
    HashSet<String> dict;
    HashMap<String, Boolean> memoMap;
    public boolean wordBreak(String s, List<String> wordDict) {
        this.dict = new HashSet<>(wordDict);
        this.memoMap = new HashMap<>();
        return helper(s, 0);
    }

    private boolean helper(String s, int idx) {
        //base
        if(idx == s.length())
            return true;
        String str = s.substring(idx);
        if(memoMap.containsKey(str))
            return false;
        //logic
        for (int i = idx; i < s.length(); i++) {
            if(dict.contains(s.substring(idx, i+1))){
                if(helper(s, i + 1))
                    return true;
            }
        }
        // 
        memoMap.put(str, false);
        return false;
    }
}

/*
* Approach2: Tabulation : bottom up dp
 - The approach is to check up until a point if the string is valid,
    -if valid, then check for the substring from that point onwards
    - else no need to iterate
    - LEETCODE - use two pointers i and j. i to iterate throught the string and j to iterate through the substring
    - true -> at index 0 of dp array because string before L is always valid
    - i = 1 -> j = 0 -> char is E -> up until j, is the string valid? if it is, then check if the dictionary contains substring between i and j, if it does that means its a valid word so set it to true
 - TC: O(n^2) -> iterate through the string and the substring
 - SC: O(n) -> for dp array
 */
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> dict = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        for(int i = 1; i <= s.length(); i++){
            for(int j = 0; j < i; j++){
                if(dp[j] && dict.contains(s.substring(j, i)))
                    dp[i] = true;
            }
        }
        return dp[s.length()];
    }
}

/*
* Approach 3: Using BFS to split the string 
TC: O(n^2) 
SC: O(n) 
 */
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        boolean[] visited = new boolean[s.length()];
        Queue<Integer> q = new LinkedList<>();

        q.add(0);

        while (!q.isEmpty()) {
            int start = q.poll();

            if(!visited[start]){
                for (int end = start + 1; end <= s.length(); end++) {
                    if(set.contains(s.substring(start, end))){
                        if(end == s.length())
                            return true;
                        q.add(end);
                    }
                }
                visited[start] = true;
            }
        }
        return false;
    }
}