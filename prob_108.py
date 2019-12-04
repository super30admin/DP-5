#leetcode 139
#bruteforce
#algo : CReate a hash set to get the presence of word in dictionary in O(1), and then we get throught the string to find all the possoible word combinatios
#Time Limit Exceeded error
class Solution(object):
    def wordBreak(self, s, wordDict):
        """
        :type s: str
        :type wordDict: List[str]
        :rtype: bool
        """
        # variables

        hash_set = set(wordDict) # to check for string in O(1)
        # retur
        # print(hash_set)
        return self.helper(s, hash_set)

    def helper(self, s, hash_set):
        # base case
        if not (s):
            return True
        len_str = len(s)
        # logic
        for i in range(len_str + 1): #here len_str + 1 is needed as we need to find till the last leeter
            # print('---')
            if s[:i] in hash_set and self.helper(s[i:], hash_set): # here it checks till  0 to i-1 in s
                # print('---')
                return True
        return False

#DP solution
class Solution(object):
    def wordBreak(self, s, wordDict):
        """
        :type s: str
        :type wordDict: List[str]
        :rtype: bool
        """
        # variables

        hash_set = set(wordDict)
        # dp
        dp = [0 for i in range(len(
            s) + 1)]  # intiall append extra 1 , so that whenever we check for the previous letter that is a valid word or no, intitial one helps keep the logic intact
        dp[0] = 1

        for i in range(1, len(dp), 1):
            for j in range(0, i, 1):
                if dp[j] == 1 and s[j:i] in hash_set:
                    # print(";;;",i,j)
                    dp[i] = 1
        # dp array for
        # "leetcode"
        # ["leet","code"] is
        # [1, 0, 0, 0, 1, 0, 0, 0, 1]
        # and for  "catsandog"
        # ["cat","cats","sand","dog"]
        # dp array is [1, 0, 0, 1, 1, 0, 0, 1, 0, 0]
        if dp[len(dp) - 1] == 1:
            return True
        return False


