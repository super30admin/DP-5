-------------------------------- Word Break Recursively ---------------------------------------------
# Time Complexity : O(N**2XL)where n is the length of s and L is the average length of the word in dict
# Space Complexity : O(1)
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this : No
# 
# I will check for all the possible substrings in the s and check if that string is 
in the wordDict or not and call recursively the function on string from next character.
If the words found I will return True, else False

class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        if not s:
            return True
        
        def recurse(s, index):
            if index == len(s):
                return True
            
            
            for i in range(index,len(s)):
                if s[index:i+1] in d and recurse(s, i+1):
                    return True
            return False
        
        d = set()
        for i in wordDict:
            d.add(i)
            
        return recurse(s, 0)
        
        
-------------------------------- Word Break DP---------------------------------------------
# Time Complexity : O(N)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this : No
# 
# Here first I will initialize dp and place 1 at other position as empty string will return True
# and I will iterate through string and dp array, and check if the word before index is present in dict or not by 
#checking the dp[index] value if yes we will check the other side string is in the array or not.
# If yes we will return True, else False.

class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        if not s:
            return True
        d = set()
        for i in wordDict:
            d.add(i)
        dp = [0 for i in range(len(s)+1)]
        dp[0] = 1
        
        i = 0
        j = 0
        for i in range(len(dp)):
            j = 0
            
            while j<i:
                if dp[j] == 1 and s[j:i] in d:
                    dp[i]= 1
                
                j +=1
        return True if dp[-1] else False