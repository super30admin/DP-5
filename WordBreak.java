import java.util.*;
public class WordBreak {

    public static boolean wordBreak(String s, List<String> wordDict)
    {
        if(s.length() == 0 || s == null) return false;
        HashSet<String> set = new HashSet<>(wordDict);


        boolean dp[] = new boolean[s.length()+1];

        dp[0] = true;

        for(int i =0;i<=s.length();i++)
        {
            for(int j = 0;j<i;j++)
            {
                if(dp[j]==true)
                {
                    String sub = s.substring(j, i);

                    if(set.contains(sub))
                    {
                        dp[i] = true;
                    }
                }
            }
        }

        return dp[s.length()];

    }

    public static void main(String args[])
    {
        List<String> wordDict = new ArrayList<>();
        wordDict.add("leet");
        wordDict.add("code");
        System.out.println(wordBreak("leetcode", wordDict));
    }

}
