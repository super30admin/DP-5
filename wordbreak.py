#Time Complexity: O(l3)
#Space Complexity: O(l)
class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        wordDictSet = set(wordDict)
        checkList = [False]*(len(s)+1)
        checkList[0] = True
        for i in range(len(s)+1):
            for j in range(i):
                if checkList[j] == True and s[j:i] in wordDictSet:
                    checkList[i] = True
                    break
                    
        return checkList[-1]