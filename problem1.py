#time complexity: O(len(s)*len(s))
#space complexity: O(len(wordDict))+ O(len(s))
#ran on leetcode: Yes
#i starts from 0 to len(s). j starts from 0 till i. In each iteration for i we check whether any substring that ends with i  is present in wordDict.
class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        D=set()
        for i in wordDict:
            D.add(i)
        L=[False]*(len(s)+1)
        L[0]=True
        i=1
        j=0
        for i in range(1,len(L)):
            j=0
            while(j<i):
                if(L[j]==True and s[j:i] in D):
                    L[i]=True
                    break
                j+=1
        print(L)
        return L[-1]



