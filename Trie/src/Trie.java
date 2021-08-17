public class Trie {

    private TrieNode root;

    public Trie() {
        root = new TrieNode('*', false);
    }

    public void insert(String word) {

        char[] arr = word.toCharArray();

        TrieNode current = root;

        for (char c : arr) {

            if (!current.children.containsKey(c)) {
                current.children.put(c, new TrieNode(c, false));
            }

            current = current.children.get(c);
        }

        current.isWord = true;
    }

    public void delete(String word) {
        delete(root, word, 0);
    }

    public boolean delete(TrieNode current, String word, int index){

        // Checks for the last character in the word
        if(index == word.length()){
            if(!current.isWord) return false;
            current.isWord = false;
            return current.children.isEmpty();
        }

        char c = word.charAt(index);

        TrieNode node = current.children.get(c);
        if(node == null) return false;

        // For each word, check if it should be removed
        boolean shouldDeleteCurrentNode = delete(node, word, index+1) && !node.isWord;

        if(shouldDeleteCurrentNode){
            current.children.remove(c);
            return current.children.isEmpty();
        }

        return false;
    }

    public boolean search(String word) {

        char[] arr = word.toCharArray();

        TrieNode current = root;

        for (char c : arr) {
            if (!current.children.containsKey(c)) return false;

            current = current.children.get(c);
        }

        return current.isWord;

    }

    public boolean startsWith(String prefix) {
        char[] arr = prefix.toCharArray();

        TrieNode current = root;

        for (char c : arr) {
            if (!current.children.containsKey(c)) return false;
            current = current.children.get(c);
        }

        return true;
    }



    public static void main(String[] args) {

        Trie trie = new Trie();

        trie.insert("apple");

        System.out.println(trie.search("apple"));
        System.out.println(trie.search("app"));
        System.out.println(trie.startsWith("app"));

        trie.insert("app");
        System.out.println(trie.search("app"));

        trie.delete("app");
        System.out.println(trie.search("app"));

    }
}
