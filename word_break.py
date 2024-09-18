class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        hash_set=set(wordDict)
        memo={}
        def DFS(s):
            if not s:
                return True
            if s not in memo:
                memo[s]=False
                for i in range(1,len(s)+1):
                    if s[:i] in hash_set:
                        if DFS(s[i:]):
                            memo[s]=True
                            break
                return memo[s]
        return DFS(s)



"""
Time Complexity: O(n^2)
Space Complexity: O(n)

"""