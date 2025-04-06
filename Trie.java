public class Trie {
    private TrieNode root;
    private int height;

    public Trie() {
        this.root = new TrieNode();
        this.height = 0;
    }

    public boolean insert(String string) {
        // Dummy reference node to traverse on the trie
        TrieNode dummy = this.root;
        int nodeCounter = 0;

        // Traverse the trie for each character on the given string
        for (int i = 0; i < string.length(); i++) {
            Character currentChar = Character.valueOf(string.charAt(i));
            
            // If there is no key for the current character, add it
            if (!dummy.getKeys().containsKey(currentChar)) {
                TrieNode newKey = new TrieNode();
                dummy.getKeys().put(currentChar, newKey);
            }
            
            // Update dummy to point to the nested key
            dummy = dummy.getKeys().get(currentChar);
            nodeCounter += 1;
        }

        if (nodeCounter > this.height) {
            this.height = nodeCounter;
        }

        // Mark the string as completed
        if (dummy.getStringValue() == null) {
            dummy.setStringValue(string);
            return true;
        }
        return false;
    }

    public boolean search(String string) {
        // Dummy reference node to traverse on the trie
        TrieNode dummy = this.root;

        // Try to traverse on the trie based on the characters in string
        for (int i = 0; i < string.length(); i++) {
            // If there is no key that matches the current char, return false
            Character currentChar = Character.valueOf(string.charAt(i));
            if (!dummy.getKeys().containsKey(currentChar)) {
                return false;
            }
            
            // Update dummy to point to the nested key
            dummy = dummy.getKeys().get(currentChar);
        }

        // After traversing the trie for all the characters, check if the string 
        // is not null
        if (dummy.getStringValue() != null) {
            return true;
        }
        return false;
    }

    public boolean startsWith(String string) {
        TrieNode dummy = this.root;
        for (int i = 0; i < string.length(); i++) {
            Character currentChar = Character.valueOf(string.charAt(i));
            if (!dummy.getKeys().containsKey(currentChar)) {
                return false;
            }
            dummy = dummy.getKeys().get(currentChar);
        } 
        return true;
    }

    public int getHeight() {
        return this.height;
    }
}
