class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        word_set=set(wordDict)
        t=[False for _ in range(len(s)+1)]
        t[0]=True
        
        for i in range(1,len(s)+1):
            for j in range(i):
                if t[j] and s[j:i] in word_set:
                    t[i]=True
                    break
                    
        return t[len(s)]