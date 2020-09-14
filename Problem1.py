#Time complexity: O(n^2) where n is the length of s
#Space complexity: O(n)
#Works on leetcode: yes
#Appraoch: Here we have a dp array initialized with all False and then we iterate through the dp and also to ith position
#in a second loop (j). If the dp[j] is True and the s[j-i] substring is in the dictionary, we set dp[i] as True. We return
#dp[-1] in the end

class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        words = set(wordDict)
        ans = [False]*(len(s)+1)
        ans[0] = True
        for i in range(1,len(ans)):
            for j in range(i):
                if ans[j] and s[j:i] in words:
                    ans[i] = True
                    break
        return ans[-1]