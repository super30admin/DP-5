class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        table = [False for _ in range(len(s)+1)]
        table[0] = True # I can always reach index 0
        for i in range(len(s)):
            if table[i] == True:
                for word in wordDict:
                    if s[i:i+len(word)] == word:
                        table[i + len(word)] = True
        return table[-1]
   
TC: O(nk)
SC: O(nk)