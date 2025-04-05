public class Main {
    public static void main(String[] args) {
        // Create Trie
        Trie myTrie = new Trie();
        myTrie.insert("angel");
        System.out.println("is 'angel' in the trie? " + myTrie.search("angel"));
        System.out.println("is 'ang' in the trie? " + myTrie.search("ang"));
        System.out.println("do the trie starts with 'ang'? " + myTrie.startsWith("ang"));
        System.out.println("do the trie starts with 'anh'? " + myTrie.startsWith("anh"));

    }
}
