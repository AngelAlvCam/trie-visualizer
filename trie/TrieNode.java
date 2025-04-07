package trie;

import java.util.HashMap;

class TrieNode {
    private String stringValue;
    private HashMap<Character, TrieNode> keys;

    protected TrieNode() {
        this.stringValue = null;
        this.keys = new HashMap<Character, TrieNode>();
    }

    protected String getStringValue() {
        return this.stringValue;
    }

    protected HashMap<Character, TrieNode> getKeys() {
        return this.keys;
    }

    protected void setStringValue(String stringValue) {
        this.stringValue = stringValue;
    }

}
