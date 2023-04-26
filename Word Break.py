class Solution:
    # Recursive Solution
    # Time Complexity: O(n**n)
    # Space complexity: O(n)

    # def wordBreak(self, s: str, wordDict: List[str]) -> bool:
    #     # global hset
    #     hset = set(wordDict)

    #     def helper(s):
    #         # global hset
    #         # Base
    #         if not s:
    #             return True
    #         # Logic
    #         for i in range(len(s)):
    #             sub = s[:i+1]
    #             if sub in hset and helper(s[i+1:]):
    #                 return True
    #         return False
    #     return helper(s)

    # DP Approach 2

    # def wordBreak(self, s: str, wordDict: List[str]) -> bool:
    #     # Time Complexity: O(m*n + n**3)
    #     # Space Complexity: O(n)

    #     memomap = {}
    #     hset = set(wordDict) # O(m*n)

    #     def helper(s):
    #         # global hset
    #         # Base
    #         if not s:
    #             return True
    #         # Logic
    #         for i in range(len(s)): # O(n)
    #             sub = s[:i+1]
    #             if sub in hset: # O(n)
    #                 restofstr = s[i+1:]
    #                 if restofstr not in memomap: # O(n)
    #                     result = helper(restofstr)
    #                     memomap[restofstr] = result
    #                 result = memomap[restofstr]
    #                 if result: return result
    #         return False

    #     return helper(s)

    # DP Approach 3
    #     # Time Complexity: O(m*n + n**3)
    #     # Space Complexity: O(n)
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        hset = set(wordDict)
        dp = [False for i in range(len(s) + 1)]
        dp[0] = True

        for i in range(len(dp)):
            for j in range(i):
                if dp[j] and s[j:i] in hset:
                    dp[i] = True
                    break

        return dp[-1]


















