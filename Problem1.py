# Time Complexity : O(n^2) 
# Space Complexity :O(n) 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Your code here along with comments explaining your approach

class Solution:
    def wordBreak(self, s, wordDict):
        if len(s) == 0:
            return True 
        dp = [False for _ in range(len(s) + 1)]
        dp[0] = True 
        map_ = set(wordDict)
        for i in range(1,len(dp)):
            for j in range(0,i):
                if dp[j] and (s[j:i] in map_):
                    dp[i] = True 
        return dp[-1]
        
        # return self.helper(s,set(wordDict))
    
    # def helper(self, s, wordDict):
    #     # base 
    #     if len(s) == 0:
    #         return True 
        
    #     # logic 
    #     for i in range(len(s)+1):
    #         if (s[:i] in wordDict) and self.helper(s[i:], wordDict):
    #             return True 
        
    #     return False

if __name__ == "__main__":
    s = Solution()
    # Test case 1 => True
    print(s.wordBreak("leetcode", ['leet','code','gas']))
    
    # Test case 2  => True
    print(s.wordBreak("codegas", ['leet','code','gas']))
    
    # Test case 3 => False
    print(s.wordBreak("codegass", ['leet','code','gas']))