class Solution:
    
    """
    Description: given a non-empty string and word dict, determine if string can be segmented using word dict
    
    Time Complexity: O(n^3)
    Space Complexity: O(n)
    
    Approach: 
    - start dp_array with first value as True with length = len(s) + 1
    - update the array at each step by comparing all preceeding substrings to the wordDict
    - return last value in dp_array as answer
    """
    
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        
        if len(s) == 0 or s == None: return False
        if len(wordDict) == 0 or wordDict == None: return False

        dp_array = [False]*(len(s) + 1)

        dp_array[0] = True
        for i in range(1, len(dp_array)):
            for j in range(i):
                if dp_array[j] and s[j: i] in wordDict:
                    dp_array[i] = True; break

        return dp_array[-1]
