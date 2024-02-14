class Solution {

    Map<Character, Pair<Boolean, Map>> trie = new HashMap<>();

    private void initTrie(List<String> dict){
        for(String s : dict){
            char[] chars = s.toCharArray();
            Map<Character, Pair<Boolean, Map>> map = trie;
            for(int i = 0; i < chars.length; i++){
                char c = chars[i];
                if(!map.containsKey(c)){
                    map.put(c, new Pair<>(false, new HashMap<>()));
                } 
                if(i == chars.length-1){
                    Pair<Boolean, Map> old = map.get(c);
                    map.put(c, new Pair<>(true, old.getValue()));
                    //System.out.println("set termination for " + s + " at character " + c);
                }
                map = map.get(c).getValue();
            }
        }
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        initTrie(wordDict);
        boolean[] states = new boolean[s.length()+1];
        states[states.length-1] = true;
        for(int i = states.length-2; i > -1; i--){
            //System.out.println("-----");
            // iterate through trie for susbtring(i+1, end)
            Map<Character, Pair<Boolean, Map>> map = trie;
            for(int j = i+1; j < states.length; j++){
                char c = s.charAt(j-1);
                //System.out.println(c);
                if(!map.containsKey(c)){
                    states[i] = false;
                    break;
                }
                Pair<Boolean, Map> pair = map.get(c);
                if(states[j] && pair.getKey()){
                    states[i] = true;
                    break;
                }
                map = pair.getValue();
            }
        }
        return states[0];
    }
}
