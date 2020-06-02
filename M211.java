class WordDictionary {

    class TrieNode{
        public TrieNode[] children = new TrieNode[26];
        public String word = ""; 
    }
    TrieNode root;
    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode();
        root.word = "";
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode node = root;
        char[] wordC = word.toCharArray();
        for(char c : wordC)
        {
            if(node.children[c-'a']==null)
            {
                node.children[c-'a']=new TrieNode();
            }
            node = node.children[c-'a'];
        }
        node.word = word;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return match(word.toCharArray(), root, 0);
    }
    
    public boolean match(char[] word, TrieNode root, int length){
        if(length == word.length) return !root.word.toString().equals("");
        if(word[length]=='.')
        {
            boolean result = false;
            for(int i=0;i<26;i++)
            {
                result |= (root.children[i]!=null && match(word, root.children[i], length+1));
            }
            return result;
        }
        else{
            return root.children[word[length]-'a']!=null && match(word, root.children[word[length]-'a'], length+1);
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */