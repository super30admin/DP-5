
// Time - O(n^4)
// Space - O(n)


class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        if(s == null) return false;

        HashSet<String> set = new HashSet<>(wordDict); // put the wordDict in the hashset
        int n = s.length();

        boolean [] dp = new boolean[n+1];
        dp[0] = true;

        for(int i = 1; i < dp.length; i++) {

            for(int j = 0; j < i; j++) {

                if(dp[j]  && set.contains(s.substring(j,i))) { // initially all the values in dp array are false if dp[j] element is true and set contains substring then make dp element as true and break
                    dp[i] = true;
                    break;
                }


            }

        }

        return dp[dp.length - 1];

    }
}