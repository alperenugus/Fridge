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

    }
}
