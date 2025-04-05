public class Trie {
    private TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }

    public void insert(String string) {
        // Dummy reference node to traverse on the trie
        TrieNode dummy = this.root;

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
        }

        // Mark the string as completed
        dummy.setStringValue(string);
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
}
