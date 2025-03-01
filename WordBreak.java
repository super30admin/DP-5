import java.util.HashSet;
import java.util.List;

//Time Complexity: O(n^2)
//Space Complexity: O(n)

public class WordBreak {
        HashSet<String> set;
        public boolean wordBreak(String s, List<String> wordDict) {
            if(s == null || s.length() ==0 || wordDict.size() == 0){
                return false;
            }
            set = new HashSet<>(wordDict);
            int n = s.length();
            boolean[] w = new boolean[n+1];

            w[0] = true;;
            for(int i=0;i < n+1;i++){
                for(int j=0;j<i;j++){
                    if(w[j]){
                        if(set.contains(s.substring(j, i))){
                            w[i] = true;
                            break;
                        }
                    }
                }
            }

            for(int k=0;k<w.length;k++){
                System.out.print(w[k]+" ");
            }
            return w[n];
        }

}
