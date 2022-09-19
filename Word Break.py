# # For-loop based recursion
# # Time Complexity: O(n^n)
# # Space Complexity: O(h)
# class Solution:
#     def wordBreak(self, s: str, wordDict: List[str]) -> bool:
#         h = set(wordDict)
        
#         def helper(s):
#             if len(s) == 0:
#                 return True
            
#             for i in range(len(s)):
#                 substr = s[0:i+1]
#                 if substr in h and helper(s[i+1:]):
#                     return True
#             return False
        
#         return helper(s)

# For-loop based recursion
# Time Complexity: O(n^2*n) = O(n^3) | O(l^4) is the actual TC where l is the length of str and we don't ignore the substr length
# Space Complexity: O(h)
class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        h = set(wordDict)
        dp = [False for _ in range(len(s)+1)]
        dp[0] = True
        
        for i in range(len(s)+1): # n time
            for j in range(i): # n time
                if dp[j] and s[j:i] in h: # Takes n time to search in set as we have to check for each character in the word. Use trie to optimize this
                    dp[i] = True
                    break
                    
        return dp[len(s)]