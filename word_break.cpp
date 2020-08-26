// Time Complexity : O(n^n)
// Space Complexity : O(no_of_strings)
// Any problem you faced while coding this :
//How to search within in the try for the word was a bit confusing.

// Your code here along with comments explaining your approach
//1. Construct a Trie with given input words.
//2. Traverse throught th trie by partitioning it in two parts. 
//3. When first part is found recurse on the second part of the TRie
//4. Make sure to go till end of strig to check whether its empty or not and then return true. 

class Solution {
public:
    class TrieNode{
      public:
        bool word_end=false;
        TrieNode* child[26]={NULL};
    };
    
    TrieNode* root;
    
    void root_initialize(){
        root = new TrieNode();
    }
    
    void insert_str(string str){
        TrieNode* curr =root;
        int str_size = str.size();
        for(int i=0; i<str_size; i++){
            int alpha_num = str[i]-'a';
            if(curr->child[alpha_num]==NULL){
                curr->child[alpha_num] = new TrieNode();
            }
            curr = curr->child[alpha_num];
        }
        curr->word_end=true;
    }
    
    bool search_str(string str){
        
        TrieNode* navigate = root;
        int i;
        int s_size = str.length();
        
        for(i=0; i<s_size; i++){
            int alpha_num = str[i] - 'a';
            if(navigate->child[alpha_num]==NULL){
                return false;
            }else{
                navigate = navigate->child[alpha_num];
                if(navigate->word_end == true && i==s_size-1){
                   return true;
                }
            }
        }
        return false;
    }
    
    bool wordBreak(string s, vector<string>& wordDict) {
        //edge
        if((wordDict.size()==0 && s.length()!=0) || (wordDict.size()!=0 && s.length()==0))
            return false;
        
        //logic
        root_initialize();
        int word_size = wordDict.size();
        for(int i=0; i<word_size; i++){
            insert_str(wordDict[i]);
        }
        return helper(s);
        
    }
    
    bool helper (string s){
        
        if(s.length()==0)
            return true;
        //logic
        for(int i=0; i<=s.length(); i++){
            if(search_str(s.substr(0,i)) && helper(s.substr(i))){
                cout<<s.substr(0,i)<<" "<<s.substr(i)<<endl;
                return true; 
            }
                
        }
        
        return false;
    }
};


// Time Complexity : O(n^2 * l) (Traversing through the Trie)
// Space Complexity : O(no_of_strings)
// Any problem you faced while coding this :
//How to search within in the try for the word was a bit confusing.

// Your code here along with comments explaining your approach
//1. Construct a Trie with given input words.
//2. Traverse throught th trie by partitioning it in two parts.
//3. When first part is found recurse on the second part of the TRie
//4. Make sure to go till end of strig to check whether its empty or not and then return true.

class Solution {
public:
    class TrieNode{
      public:
        bool word_end=false;
        TrieNode* child[26]={NULL};
    };
    
    TrieNode* root;
    
    void root_initialize(){
        root = new TrieNode();
    }
    
    void insert_str(string str){
        TrieNode* curr =root;
        int str_size = str.size();
        for(int i=0; i<str_size; i++){
            int alpha_num = str[i]-'a';
            if(curr->child[alpha_num]==NULL){
                curr->child[alpha_num] = new TrieNode();
            }
            curr = curr->child[alpha_num];
        }
        curr->word_end=true;
    }
    
    bool search_str(string str){
        
        TrieNode* navigate = root;
        int i;
        int s_size = str.length();
        
        for(i=0; i<s_size; i++){
            int alpha_num = str[i] - 'a';
            if(navigate->child[alpha_num]==NULL){
                return false;
            }else{
                navigate = navigate->child[alpha_num];
                if(navigate->word_end == true && i==s_size-1){
                   return true;
                }
            }
        }
        return false;
    }
    
    bool wordBreak(string s, vector<string>& wordDict) {
        //edge
        if((wordDict.size()==0 && s.length()!=0) || (wordDict.size()!=0 && s.length()==0))
            return false;
        
        //logic
        root_initialize();
        int word_size = wordDict.size();
        for(int i=0; i<word_size; i++){
            insert_str(wordDict[i]);
        }
        int s_size = s.length();
        vector<bool> dp(s_size+1);
        
        //empty space in the front
        //Prefix exists
        dp[0]=true;
        
        for(int i=0; i< dp.size(); i++){
            for(int j=0; j<i; j++){
              if(dp[j] == true){
                 if(search_str(s.substr(j,i-j))){ //Understand partition
                   dp[i]=true;
                     break;
                 }
              }
            }
        }
        return dp[s_size] == 1? true: false;
    }
};
