/* brute force exponentail
class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        if s is None or len(s) == 0:
            return True
        
        self.mapping = set()
        for word in wordDict:
            self.mapping.add(word)
        
        self.s_len = len(s)
        return self.helper(s, 0)
    
    def helper(self, s, index):
        #base
        if index > len(s) - 1:
            return True
        
        #logic
        for i in range(index+1, self.s_len+1):
            if s[index:i] in self.mapping:
                if self.helper(s, i):
                    return True
        return False

class Solution {
    HashSet<String> set;
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || s.length() == 0)
            return true;
        
        set = new HashSet<>(wordDict);
        return helper(s, 0);
    }
    private boolean helper(String s, int index){
        // base
        if (index > s.length()-1)
            return true;
        
        // logic
        for (int i=index+1; i<s.length()+1; i++){
            if (set.contains(s.substring(index, i))){
                if (helper(s, i)){
                    return true;
                }
            }
        }
        return false;
    }
}
*/

/*
class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        if s is None or len(s) == 0:
            return True
        
        dp = [False]*(len(s)+1)
        dp[0] = True
        
        wordset = set(wordDict)
        
        for i in range(len(dp)):
            for j in range(i):
                
                if dp[j] and s[j:i] in wordset:
                    dp[i] = True
                    break
        
        return dp[len(dp)-1]
*/

// Time - O(n^2) where n is size of s
// Space - O(n)
// Logic - dp array is filled if a particular word can be formed. Also we are not concerned how the word will form, we only see whether 
// it can be formed or not.
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || s.length() == 0)
            return true;
        
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        HashSet<String> set = new HashSet<>(wordDict);
        
        for (int i=0; i<dp.length; i++){
            for (int j=0; j<i; j++){
                if (dp[j] && set.contains(s.substring(j,i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[dp.length-1];
    }
}