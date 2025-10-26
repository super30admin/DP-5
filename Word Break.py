'''
Solution 1: Recursion 
    - For loop based recursion, We try all possible splits at this pivot
    - if the splited sub-string is present in dictionary, we do next recursive call
      on rest of the string. 
    - If the recursive call returns true at this pivot, meaning we were able to split 
      the rest of the string, we return True. Else we try the next split at this pivot
    - if all splits are tried at this pivot, we return False
Time Complexity: N = Total words, L = average length of word, k = length(string s)
    - O(N*L) - inserting in a set
    - O(k*(2^k)) - Split/no-split at each pivot. Checking if the split is present in the Wordset
Space Complexity:
    - O(N) - wordDictionary set
    - O(K) - Recursive stack
    - Total: O(N+L) ~ O(N) As total words> length of string
'''
class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        wordDict_set = set(wordDict) 

        return self.helper(s,wordDict_set,0)

    def helper(self,s,wordDict_set,pivot):
        # base
        if pivot==len(s): # if we reach end and no more string to split, we have found a valid partition
            return True

        # logic
        for index in range(pivot,len(s)):
            sub_str = s[pivot:index+1] # split the word

            if sub_str in wordDict_set: # if this split present in dictionary
                if self.helper(s,wordDict_set,index+1): # if we have valid splits on next sub-string
                    return True
        
        return False # Tried all splits, but failed

'''
Solution 2: Recursion + Memoization
    - For loop based recursion, We try all possible splits at this pivot
    - if the splited sub-string is present in dictionary, we do next recursive call
      on rest of the string. 
    - If the recursive call returns true at this pivot, meaning we were able to split 
      the rest of the string, we return True. Else we try the next split at this pivot
    - if all splits are tried at this pivot, we return False
    - we store in memory bank
Time Complexity: N = Total words, L = average length of word , k = length(string s)
    - O(N*L) - inserting in a set
    - O(k) - Split/no-split at each pivot. Checking if the split is present in the Wordset
    - Total: O(N*L)
Space Complexity:
    - O(N) - wordDictionary set
    - O(k) - memory bank
    - O(k) - recursive stack
    - Total: O(N+L+k) ~ O(N) 
'''
class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        wordDict_set = set(wordDict) 
        self.memory = {} # {pivot - True/False}
        return self.helper(s,wordDict_set,0)

    def helper(self,s,wordDict_set,pivot):
        # base
        if pivot==len(s): # if we reach end and no more string to split, we have found a valid partition
            return True
        if pivot in self.memory:
            return self.memory[pivot]

        # logic
        for index in range(pivot,len(s)):
            sub_str = s[pivot:index+1] # split the word

            if sub_str in wordDict_set: # if this split present in dictionary
                if self.helper(s,wordDict_set,index+1): # if we have valid splits on next sub-string
                    self.memory[pivot] = True # store in memory bank
                    return True
        
        self.memory[pivot] = False
        return False # Tried all splits, but failed


'''
Solution 3: Dp with Tabulation
    - Dp_array, We try all possible splits at this pivot
    - if dp_array at index left to the current split is True AND 
      the splited sub-string is present in dictionary, We set the dp_array at current
      pivot to True  
    - Else we try the next split at this pivot, j(split index): pivot --> 0 

Time Complexity: N = Total words, L = average length of word , k = length(string s)
    - O(N*L) - inserting in a set
    - O(k) - Split/no-split at each pivot. Checking if the split is present in the Wordset
    - Total: O(N*L)
Space Complexity:
    - O(N) - wordDictionary set
    - O(k) - dp_array
    - Total: O(N+k) ~ O(N) 
'''
class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        wordDict_set = set(wordDict)
        dp_array = [False]*(len(s)+1)
        dp_array[0] = True # 0th idx = "" empty split, which is valid

        for i in range(1,len(dp_array)):
            for j in range(i,-1,-1):
                sub_str = s[j-1:i+1-1] # i&j -> index on dp_array. they are 1 ahead of index on input string s 
                if dp_array[j-1] == True and sub_str in wordDict_set:
                    dp_array[i] = True
                    break 
        
        return dp_array[-1]
                