class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        if len(s) == 0 or len(wordDict) == 0:
            return true
        hashset = set()
        for word in wordDict:
            hashset.add(word)

        return self.helper(s, hashset)

    def helper(self, s, hashset):
        # base
        if len(s) == 0:
            return True

        # logic
        for i in range(0, len(s)):
            substring = s[:i+1]
            if substring in hashset and self.helper(s[i+1:], hashset):
                return True

        return False
