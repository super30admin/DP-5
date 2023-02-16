# Time Complexity :
# O(N^3)

# Space Complexity :
# O(N+W) - size of word dict or size of the word

# Did this code successfully run on Leetcode :
#Yes

#We try to insert a space in all positions and check if rest of the string can be split correctly recursively and if the word formed before the space is in the word dict. If both are true, then we are done, if either is false, then we change the position of the space and try again
#We exhaustively check all combinations of adding spaces and return if any of the splits form the words in the word dict. If they do, we return True, false otherwise
#We also store the information about solved subproblems - about whether a substring can be split in any way to form the words of word dict, and use this information when a different way of splitting tries to solve the same sub problem to avoid repeated computation

class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        self.start_pos = [None] * (len(s) + 1 )
        self.word_dict = {key:0 for key in wordDict}
        self.helper(s,0)
        return self.start_pos[0]

    def helper(self,s,start_pos):
        if s[start_pos:] in self.word_dict or s[start_pos:] == "":
            self.start_pos[start_pos] = True
            return True

        if self.start_pos[start_pos] != None:
            return self.start_pos[start_pos]

        flag = False

        for pos in range(start_pos+1,len(s)+1):
            word1 = s[start_pos:pos]
            if word1 not in self.word_dict:
                continue
            flag = self.helper(s,pos)
            if flag == True :
                break

        self.start_pos[start_pos] = flag
        return self.start_pos[start_pos]
