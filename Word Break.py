#time: O(n^3)
#space:O(n)

class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        wordset=set(wordDict)
        i=1
        j=0
        dparray=[False for i in range(len(s)+1)]
        dparray[0]=True
        while(i<=len(s)):
            j=0
            while(j<i):
                if(dparray[j] and s[j:i] in wordset):
                    dparray[i]=True
                j+=1
            i+=1
        print(dparray)
        return dparray[-1]
            
            
    