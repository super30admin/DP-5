import java.util.Set;

class Problem1 {
    Set<String> wordSet;
    Set<String> memo;//stores string which is not part of the solution
    //this is because we should be able to return back when it is not pass of the solution
    public boolean wordBreak(String s, List<String> wordDict) {
        wordSet = new HashSet<>();
        memo = new HashSet<>();
        for(String word: wordDict ){
            wordSet.add(word);
        }
        //return recurHelper(s,0);
        return memoizationHelper(s,0);
    }

    //TC:(2^N)
    public boolean recurHelper(String s,int pivot){

        //base case
        if(pivot == s.length()){
            return true;
        }

        for(int i=pivot;i<s.length();i++){
            String subStr =  s.substring(pivot,i+1);
            if(wordSet.contains(subStr) && recurHelper(s,i+1)){
                return true;
            }
        }
        return false;
    }

    //TC:O(N^2)

    public boolean memoizationHelper(String s,int pivot){

        //base case
        if(pivot == s.length()){
            return true;
        }

        if(memo.contains(s.substring(pivot,s.length()))){
            //this is the case when the string is not part of the solution
            return false;
        }
        for(int i=pivot;i<s.length();i++){
            String subStr =  s.substring(pivot,i+1);
            if(wordSet.contains(subStr) && memoizationHelper(s,i+1)){
                return true;
            }
        }
        memo.add(s.substring(pivot,s.length()));
        return false;
    }
}