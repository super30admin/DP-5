# Time complexity: O(n^2) where n in the length of the string
# Space: O(n^2) memo set storing substrings

# The top down dynamic approach is to determine if a substring is a part of the set, if yes then split and then check for that split recursively. If we don't get equal splits then return False

class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        self.wordSet = set()
        self.memo = set()
        for word in wordDict:
            self.wordSet.add(word)

        def helper(substr):
            if len(substr) == 0: return True
            if substr in self.memo: return False
            for i in range(len(substr)):
                curr = substr[0:i + 1]
                if curr in self.wordSet and helper(substr[i + 1:]):
                    return True

            self.memo.add(substr)
            return False

        return helper(s)

    # The time complexity is same O(n^2)
    # However, the space is optimized O(n) for dp array

    # The logic is similar, where we can if the previous substring is value is True in the dp array and the curr string, if yes we set the dp at that position as True otherwise False
    # Finally return the result in the final dp array. 
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        wordSet = set()
        for word in wordDict:
            wordSet.add(word)
        dp = [False] * (len(s) + 1)
        j = 0
        for i in range(len(s) + 1):
            if i == 0:
                dp[i] = True
            else:
                while j < i:
                    if dp[j] == True and s[j:i] in wordSet:
                        dp[i] = True
                        break
                    j += 1
                j = 0

        return dp[len(s)]
