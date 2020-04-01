// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach:
Given a string s and wordDict we have to see whether we can break the string into words such that all these words are present in the dictionary or not.we start with traversing through the string and check if the string is present or not.If yes we again traverse backwards to see if there is valid word present in the dictionary or not.In this maner we do this till the end of the string and we have to return the boolean of the last character in the string to know if the word break happened correctly or not.


# Time complexity --> o(n*n)
# space complexity --> o(n)
class Solution(object):
    def wordBreak(self, s, wordDict):
        """
        :type s: str
        :type wordDict: List[str]
        :rtype: bool
        """
        s='$'+s
        wordDict=set(wordDict)
        is_valid=[False for i in range(len(s)+1)]
        is_valid[0]=True
        for i in range(len(s)):
            k=i
            while k>=0:
                if s[k:i+1] in wordDict and is_valid[k-1]==True:
                    is_valid[i]=True
                k=k-1
        return is_valid[len(s)-1]