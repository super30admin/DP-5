class Solution:
    
    
    """
        
        Name : Shahreen Shahjahan Psyche
        Time : Recursive: O(N^N)
               Dynammic : O(N^2)
               
        Space: Recursive : O(N^2) [creating list in every level]
               Dynammic : O(N+1)
        
        Passed All Test Cases : Yes
    
    """
    
    def recursive(self, s, words):
        # base case
        if s == "":
            return True
        res = False
        
        for i in range(0, len(s)):
            curr_str = s[0:i+1]
            # if the current substring is present in the list then we are recursing on the remaining substring
            if curr_str in words:
                res = res or self.recursive(s[i+1:len(s)], words)
        
        return res
        
    def dp(self, s, words):
        
        records = [False for _ in range(len(s)+1)]
        records[0] = True
        
        for i in range(1, len(records)):
            for j in range(0, i):
                # if curreent position is True, that means the substring beefore it is valid
                # and from the current position to the ith position is valid, then we can
                # infer that the ith position is also valid
                if records[j] == True and s[j:i] in words:
                    records[i] = True
                    break
        return records[len(records)-1]
        
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        
        if not wordDict:
            return False
        
        if not s:
            return True
        
        words = set()
        
        for i in wordDict:
            words.add(i)
        
        return self.dp(s, words)
        # return self.recursive(s, words)
    
