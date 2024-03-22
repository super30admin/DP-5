'''
Time Complexity - O(n) for bottom up. 
Space Complexity - O(n) for bottom up and top down + recursive stack of O(n) for top bottom

works on leetcode
'''

class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        memoMap = {}
        wordSet = set(wordDict) #convert the dictionary to a hashSet
        # return self.helper(s, wordSet, memoMap) 

        #TABULATION DP
        dp = [False for i in range(len(s)+1)] #create the DP array
        dp[0] = True #set true for first character as we are able to split the string into valid words at first
        for i in range(1, len(s)+1):
            for j in range(0, i):
                if dp[j] and s[j:i] in wordSet: #check the word from j to i in the hashSet and the dp array, if true
                    dp[i] = True #set True in dp arrau for i
                    break
        return dp[len(s)]#return the last element as it will contain the final result
 
    #TOP BOTTOM DP
    def helper(self, s, wordSet, memoMap):
        if len(s) == 0: #if we reach the end return true
            return True
        if memoMap.get(s): #return value in the map for the string if present
            return memoMap.get(s)
        for i in range(0, len(s)):
            subStr = s[0:i+1] #generate the two strings
            restStr = s[i+1:len(s)]
            if subStr in wordSet:
                temp = self.helper(restStr, wordSet, memoMap) #if both are present in hashMap or are valid strings then we store true
                memoMap[restStr] = temp
                if temp:
                    return True 
                else:
                    memoMap[s] = False
        memoMap[s] = False #return false if the string is not present in the dictionary list
        return False

        