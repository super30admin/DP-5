// Time Complexity: O(n^4) -> two for loops + substring + set matching 
// Space Complexity: O(n) -> space of dictionary + dp space
// DP
public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        if(s == null || s.length() == 0)
            return true;
        
        Set<String> set = new HashSet<>(wordDict);
        
        if(set.contains(s))
            return true;
        
        boolean dp [] = new boolean[s.length()+1];
        dp[0] = true; // left of index is true i.e empty string
        
        
        for(int i = 1 ; i <= s.length() ; i ++)
        {
            for(int j = 0 ; j < i ; j++)
            {
                // do not look for a value where it was never present
                if(dp[j] == false)
                    continue;
                
                String substring = s.substring(j, i);
                if(set.contains(substring))
                {
                    dp[i] = true;
                }
            }
        }
        return dp[s.length()];
    }
}

// Time Complexity: O(2^n) length of the string
// Space Complexity: O(n)
// Brute Force
public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        if(s == null || s.length() == 0)
            return true;
                
        Set<String> set = new HashSet<>(wordDict);
        
        if(set.contains(s))
            return true;
        
        return dfs(s, set);
    
    }
    
    private boolean dfs(String s, Set<String> set)
    {
        if(0 == s.length())
            return true;
        
        // logic
        for(int i = 1 ; i <= s.length(); i++)
        {
            String firstHalf = s.substring(0, i);
            String secondHalf = s.substring(i, s.length());
            if(set.contains(firstHalf) && dfs(secondHalf, set))
            {
                return true;
            }
        }
        
        return false;
    }
}
