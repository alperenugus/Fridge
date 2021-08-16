import java.util.HashMap;

public class TrieNode {

    HashMap<Character, TrieNode> children;
    Character content;
    Boolean isWord;

    TrieNode(Character content, Boolean isWord){
        this.content = content;
        this.isWord = isWord;
        children = new HashMap<>();
    }

}
