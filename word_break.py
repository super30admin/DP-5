# Did this code successfully run on Leetcode : NO, TLE

# approach
# exhaustive brute force with recursion and backtracking
# TC: O(N^N)
# SC: O(N)

class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        
        def helper(s, path, words):
            # print(path)
            temp = ''.join(path)
            if temp == s:
                return True
            if len(temp) > len(s) or (len(temp) == len(s) and temp != s):
                return False
            for i in range(len(words)):
                path.append(words[i])
                if helper(s, path, words):
                    return True
                path.pop()
            return False
        
        return helper(s, [], wordDict)

# approach
# DP
# substring until current index can be somehow partitioned

# TC: O(N^4)
# SC: O(N)

class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        _set = set(wordDict)
        dp = [False for _ in range(len(s) + 1)]
        dp[0] = True
        for i in range(1, len(dp)):
            for j in range(i):
                if dp[j] and s[j:i] in _set:
                    dp[i] = True
                    break
        return dp[-1]