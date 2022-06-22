'''
Approach: For-loop based recursion

Time Complexity : Exhaustive 0(n*depth)
Space Complexity : Recursive Stack
On LeetCode: Yes
'''
class Solution:
    
    def __init__(self):
        self.dictWord = {}
    
    def forLoopRecursion(self,idx,inputStr):
        # base-case
        if idx == len(inputStr):
            return True
        
        # logic-case
        for i in range(idx,len(inputStr)):
            
            # create subString 
            subString = inputStr[idx:i+1]
            
            # chk subString in exist in self.dictWord
            if subString in self.dictWord:
                # do-something
                # recurse
                result = self.forLoopRecursion(i+1,inputStr)
                
                if result == False:
                    continue
                else:
                    return result
                
            else:
                continue
        '''exit of for-loop'''
        return False
    
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        
        # add wordDict into dictionary
        for word in wordDict:
            if word not in self.dictWord:
                self.dictWord[word] = "Exist"
        
        result = self.forLoopRecursion(0,s)
        # print("Result is:\t",result)
        return result