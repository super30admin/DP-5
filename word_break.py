'''
S30 Challenge:

There are two methods to solve the problem, both of them are not easy to comprehend.

Since the Memoization logic is close to bruteforce, I went with with it, I will try to rinse and repeat similar sort of problems until I get a hang of it.



Time : O(l^3)
Space: O(l)



'''

class Solution:

    def __init__(self):
        self.hash_set=set()
        self.hash_set_2 =set()
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        self.hash_set = set(wordDict)

        return self.helper(s,0)


    def helper(self,s,pivot):

        if pivot==len(s):
            return True

        curr_str = s[pivot:]
        if curr_str in self.hash_set_2:
            return False

        for i in range(pivot,len(s)):
            substr = s[pivot:i+1]


            if(substr in self.hash_set):
                if(self.helper(s, i+1)):
                    return True
        self.hash_set_2.add(curr_str)

        return False



