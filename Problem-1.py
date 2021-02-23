#Time Complexity :o(n^3)
#Space Complexity :o(n)
#Did this code successfully run on Leetcode :yes
#Any problem you faced while coding this :no
class Solution(object):
    def wordBreak(self, s, wordDict):
        """
        :type s: str
        :type wordDict: List[str]
        :rtype: bool
        """
        if(s=="" or len(wordDict)==0):
            return False
        
        setwords=set(wordDict)
        arr=[False]*(len(s)+1)
        arr[0]=True
        for i in range(1,len(s)+1):
            for j in range(i):
                if(arr[j] and s[j:i] in setwords):
                    arr[i]=True
                    break
        return arr[len(arr)-1]