package Trie;

public class WordBreak {

    public static boolean wordBreak(String[] arr, String key) {
        Trie trie = new Trie();

        for (String s: arr) {
            trie.insert(s);
        }

        return helper(0, key, trie);                
    }

    private static boolean helper(int idx, String key, Trie trie) {
        if (idx == key.length()) {
            return true;
        }

        for (int i = idx; i< key.length(); i++) {
            String leftHalf = key.substring(idx, i + 1);

            if (trie.search(leftHalf)) {
                return helper(i + 1, key, trie);
            }
        }

        return false;
    }

    public static void main(String[] args) {
        // String[] arr = { "i", "love", "like", "android", "samsung" };
        // System.out.println(wordBreak(arr, "ilikesamsung"));


        // testing startsWith()
        String[] arr = { "apple", "app", "mango", "man", "woman" };
        Trie trie = new Trie();
        
        for (String s: arr) {
            trie.insert(s);
        }

        System.out.println(trie.startsWith("app"));
        System.out.println(trie.startsWith("moon"));
        System.out.println(trie.startsWith("man"));
        System.out.println(trie.startsWith("wo"));
    }
}
