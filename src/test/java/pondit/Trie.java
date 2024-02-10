package pondit;

import javax.swing.text.StyledEditorKit;
import java.util.HashMap;

public class Trie {
    HashMap<Character, HashMap<Character, Boolean>> head = new HashMap<>();

    Trie(HashMap<Character, HashMap<Character, Boolean>> head) {
        this.head = head;
    }
    Trie() {
    }

    public void addWord(String word) {
        char[] wordChars = word.toCharArray();
        for (char c : wordChars) {
            if ( head.get(c) == null ) {
                HashMap<Character, Boolean> hm = new HashMap<>();
                head.put(c, hm);
            }
        }
    }

    public boolean searchWord(String word) {
        char[] wordChars = word.toCharArray();

        return true;
    }
}
