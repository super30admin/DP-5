class Solution:
    # TIme complexitu - O(n^2)
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:

        hmap = set(wordDict)
        dp = [False] * (len(s) +1) 
        dp[0] = True # True because string before this is empty and valid partition 
        for i in range(1,len(dp)):
            for j in range(i): #
                if dp[j] and s[j:i] in hmap: #check if previous is a valid split if yes then check if the substring exists in the hmap.
                    dp[i] = True
                    break
        return dp[len(s)]

    # def wordBreak(self, s: str, wordDict: List[str]) -> bool:

    #     hmap = set(wordDict)
    #     memo = dict()
    #     def helper(word):
    #         nonlocal hmap
    #         # base
    #         if not word:
    #             return True

    #         #logic
    #         if word in memo: return memo[word]
    #         for i,ch in enumerate(word):
    #             sub = word[:i+1]
    #             if sub in hmap and helper(word[i+1:]):
    #                 memo[word] = True
    #                 return True
    #         memo[word] = False
    #         return False

    #     return helper(s)















        # memo = {}
        # words_set = set(wordDict)

        # def dfs(temp):
        #     if temp in memo:
        #         return memo[temp]

        #     if not temp:
        #         return True

        #     if temp in words_set:
        #         return True
            
        #     for i in range(len(temp)):
        #         if temp[:i] in words_set:
        #             memo[temp[i:]] = dfs(temp[i:])
        #             if memo[temp[i:]]:
        #                 return True
            
        #     memo[temp] = False
        #     return memo[temp]
        
        # return dfs(s)

