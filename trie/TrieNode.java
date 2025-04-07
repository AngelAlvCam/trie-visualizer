package trie;

import java.util.HashMap;

public class TrieNode {
    private String stringValue;
    private HashMap<Character, TrieNode> keys;

    public TrieNode() {
        this.stringValue = null;
        this.keys = new HashMap<Character, TrieNode>();
    }

    public String getStringValue() {
        return this.stringValue;
    }

    public HashMap<Character, TrieNode> getKeys() {
        return this.keys;
    }

    public void setStringValue(String stringValue) {
        this.stringValue = stringValue;
    }

}
