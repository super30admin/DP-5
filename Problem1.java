// TC : O(2^n)

//Idea : 
// 1. check each sub string is in the dictoinary.a

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        return wordBreak(s, new HashSet<>(wordDict), 0) != null;
    }
    
    
    private String wordBreak(String str, Set<String> dict, int start) {
        StringBuffer sb = new StringBuffer();
        for (int i = start; i < str.length(); i++) {
            sb.append(str.charAt(i));
            System.out.println(sb);
            if (dict.contains(sb.toString())) {
                String nextWord = wordBreak(str, dict, i + 1);
                if (nextWord != null)
                    return sb.append(" ").append(nextWord).toString();
            }
        }
        return dict.contains(sb.toString()) ? sb.toString() : null;
    }

}
