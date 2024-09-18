# time: O(n)
# space: O(n)
class Solution(object):
    def wordBreak(self, s, wordDict):
        arr = [0] * (len(s) + 1)
        arr[0] = 1
        for i in range(1, len(s) + 1):
            for j in range(i+1):
                if arr[j] == 1:
                    word = s[j : i]
                    if word in wordDict:
                        arr[i] = 1
        print(arr)
        return arr[len(s)]
                    