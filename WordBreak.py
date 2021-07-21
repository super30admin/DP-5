class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        """DP Approach using dparray
        Time complexity-O(n^4) as we are doing substring everytime and checking in hashmap
        Space complexity-O(max(hashset, n)) where n is the length of string"""
        hashset=set()
        for i in wordDict:
            hashset.add(i)
        dparr=[False for _ in range(len(s)+1)]
        dparr[0]=True
        for i in range(1, len(s)+1):
            for j in range(0, i):
                if dparr[j] and s[j:i] in hashset:
                    dparr[i]=True
                    break
        return dparr[len(dparr)-1]
                    
        """Recursion --time limit exceeded
        Time complexity-O((length of word)^length of word)
        Space complexity-O(len(worddict))"""
#         hashset=set()
#         for i in wordDict:
#             hashset.add(i)
#         return self.helper(hashset, s)
        
#     def helper(self, hashset, s):
#         if not s:
#             return True
#         for i in range(1, len(s)+1):
#             if s[:i] in hashset:
#                 if self.helper(hashset, s[i:]):
#                     return True

        
                
                
                
            
            
        