package Trie;

import java.util.*;

public class AllUniqueSubstrings {

    public static List<String> getUniqueSubstrins(String s) {
        Trie trie = new Trie();
        
        for (int i = s.length() - 1; i >= 0; i--) {
            String sub = s.substring(i);
            trie.insert(sub);
        }

        List<String> uniqueSubstrings = new ArrayList<>();
        uniqueSubstrings.add("");
        Node node = trie.root;
        identifySubstrings(node, uniqueSubstrings, "");

        return uniqueSubstrings;
    }

    public static void identifySubstrings(Node node, List<String> uniqueStrings, String s) {
        if (node == null) {
            return;
        }

        for (int i = 0; i<26; i++) {
            if (node.children[i] != null) {
                char currentChar = (char) (i + 'a');
                String newString = s + currentChar;

                uniqueStrings.add(newString);


                identifySubstrings(node.children[i], uniqueStrings, newString);
            }
        }
    }

    public static void main(String[] args) {
        List<String> unique = getUniqueSubstrins("ababa");

        for (String u: unique) {
            System.out.println(u);
        }        
    }
    
}
