# DP - tabular
# Time Complexity : O(l*l*l)
# Space Complexity : O(l)
# Approach :
# 1. We use a dp array of size n+1 to store the results of subproblems.
# 2. dp[i] is True if the substring s[0:i] can be segmented into words from the wordDict.
# 3. We initialize the first element of the dp array to True, as an empty string can be segmented.
# 4. We iterate through the string s and for each index i, we check all possible substrings s[j:i].
# 5. If dp[j] is True and s[j:i] is in the wordDict, we set dp[i] to True.
# 6. Finally, we return dp[n], which indicates whether the entire string can be segmented.
class Solution:
    def wordBreak(self, s: str, wordDict):
        # Calculate the length of the string
        n = len(s)
        # Convert the wordDict to a set for faster lookup
        wordDict = set(wordDict)
        # Initialize a dp array of size n+1 with all values set to False
        dp = [False] * (n+1)
        # The first element of the dp array is set to True as an empty string can be segmented
        dp[0] = True

        # Iterate through the string s
        for i in range(1, n+1):
            # Check all possible substrings s[j:i]
            for j in range(0, i):
                # If dp[j] is True and s[j:i] is in the wordDict, set dp[i] to True and break through the loop
                if dp[j]:
                    if s[j:i] in wordDict:
                        dp[i] = True
                        break
        # Return the last element of the dp array, which indicates whether the entire string can be segmented
        # into words from the wordDict
        return dp[-1]

# DP - memoization
# Time Complexity : O(l*l*l)
# Space Complexity : O(n)
# Approach :
# 1. We use a memoSet to store the words that we have already checked and found to be not in the wordDict.
# 2. We use a dfs function to check if the substring s[pivot:] can be segmented into words from the wordDict.
# 3. If the pivot index is equal to the length of the string, we return True.
# 4. We check if the substring s[pivot:] is in the memoSet, if it is, we return False.
# 5. We iterate through the string s and for each index i, we check all possible substrings s[pivot:i+1].
# 6. If the substring s[pivot:i+1] is in the wordDict, we call the dfs function recursively with the next index i+1.
# 7. If the dfs function returns True, we return True.
# 8. If we have checked all possible substrings and none of them are in the wordDict, we add the substring s[pivot:] to the memoSet and return False.
# 9. Finally, we return the result of the dfs function starting from index 0.
class Solution:
    def wordBreak(self, s: str, wordDict) -> bool:
        # Calculate the length of the string
        n = len(s)
        # Convert the wordDict to a set for faster lookup
        wordDict = set(wordDict)
        # Initialize a memoSet to store the words that we have already checked and found to be not in the wordDict
        memoSet = set()
        
        # Define a dfs function to check if the substring s[pivot:] can be segmented into words from the wordDict
        # The dfs function takes the pivot index as an argument
        def dfs(pivot):
            # If the pivot index is equal to the length of the string, we return True because we will have segmented the entire string and found all parts in the wordDict
            if pivot == n:
                return True
            # get thr substring that we are going to check
            string = s[pivot:]
            # If this sunstring is already there in the memoSet, we return False because we have already checked this substring and found it to be not in the wordDict
            if string in memoSet: return False
            # Iterate through the string s and for each index i, we check all possible substrings s[pivot:i+1]
            for i in range(pivot, n):
                # Get the substring
                substring = s[pivot:i+1]
                # If this substring is in the wordDict, we call the dfs function recursively with the next index i+1
                if substring in wordDict:
                    # If the dfs function returns True, we return True
                    if dfs(i+1):
                        return True
            # If we have checked all possible substrings and none of them are in the wordDict, we add the substring s[pivot:] to the memoSet and return False   
            memoSet.add(string)
            return False
        # Finally, we return the result of the dfs function starting from index 0
        return dfs(0)

# Brute force : O(n^n)
class Solution:
    def wordBreak(self, s: str, wordDict) -> bool:
        n = len(s)
        wordDict = set(wordDict)
        res = []
        def dfs(pivot):
            if pivot == n:
                return True
            for i in range(pivot, n):
                substring = s[pivot:i+1]

                if substring in wordDict:
                    if dfs(i+1):
                        return True
            return False


        return dfs(0)