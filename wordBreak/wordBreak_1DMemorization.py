'''
Approach: 1D Memorization

Time Complexity : 
    1. performing nested traversal 
    2. creating subList
    0(n^3)
    
Space Complexity : 0(1)
On LeetCode: Yes
'''
class Solution:
    
    def __init__(self):
        self.dpList = None
        self.dictWord = {}
        
    def memorization1D(self,inputString):
        # initialize j
        j = None
        
        for i in range(1,len(self.dpList)):
            
            # reset j to 0
            j = 0
            
            # set to default False
            self.dpList[i] = False
            
            # iterate the string
            while j!=i:
                
                # 1. create subString
                subString = inputString[j:i]

                # 2. chk subString in self.dictWord
                if self.dpList[j] == True and subString in self.dictWord:
                    self.dpList[i] = True
                    break
                else:
                    '''
                    Bhaisaab jab mera pichla subString i.e [start:j] hee FALSE hai
                    currentSubString ko check karke mein kya karunga!!!
                    DAFA - KARO
                    '''
                    # move j+1
                    j += 1
            '''end of while loop'''
        
        # return the last index of the dpList
        return self.dpList[-1]
    
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        
        # add wordDict into dictionary
        for word in wordDict:
            if word not in self.dictWord:
                self.dictWord[word] = "Exist"
        
        # initlize my dpList : 1 index more just to get value of blank list
        self.dpList = [None]*(len(s)+1)
        self.dpList[0] = True
        
        # perform memorization1D
        return self.memorization1D(s)
        