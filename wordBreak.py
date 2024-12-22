# Time:O(n*k) k = pivot word
# Space:O(n) for memomap and recursion stack
# Leetcode: Yes
# Issues:

# 3ms hashset memoisation
class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        memoMap = set()                                             # hashset is faster with memo

        def helper(s,pivot):
            if pivot == len(s):                                     # processed entire string
                return True

            pvstr = s[pivot:]                                       # Check memoization
            if pvstr in memoMap:
                return False

            for i in range(pivot, len(s)):
                subs = s[pivot:i+1]
                if subs in wordDict and helper(s,i+1):
                    return True 
                
            memoMap.add(pvstr)
            return False

        return helper(s,0)


# 8ms hashmap memoisation
class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        memoMap = {}

        def helper(pivot):
            
            if pivot == len(s):                         # processed entire string
                return True
            
            pvstr = s[pivot:]                           # Check memoization
            if pvstr in memoMap:
                return memoMap[pvstr]

            for i in range(pivot, len(s)):              # Try every substring starting frm 'pivot'
                subs = s[pivot:i + 1]
                if subs in wordDict:
                    if helper(i + 1):
                        memoMap[pvstr] = True               # added step // {'apple': True, 'penapple': True}
                        return True
            
            memoMap[pvstr] = False                      # No valid item found // 'og': {'og': False}
            return False

        return helper(0)
    