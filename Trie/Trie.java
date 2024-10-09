package Trie;

class Node {
    Node[] children;
    boolean eow;

    Node() {
        children = new Node[26];
        eow = false;
    }
}

public class Trie {

    public Node root;

    public Trie() {
        root = new Node();
    }

    public void insert(String s) {
        Node temp = root;

        for (int level = 0; level < s.length(); level++) {
            int idx = s.charAt(level) - 'a';

            if (temp.children[idx] == null) {
                temp.children[idx] = new Node();

            }

            temp = temp.children[idx];
        }

        temp.eow = true;
    }

    public boolean search(String word) {
        Node temp = root;

        for (int i = 0; i<word.length(); i++) {
            int idx = word.charAt(i) - 'a';

            if (temp.children[idx] == null) {
                return false;
            } 

            temp = temp.children[idx];
        }

        return temp.eow;
    }

    public boolean startsWith(String s) {
        Node curr = root;

        for (int i = 0; i<s.length(); i++) {
            int idx = s.charAt(i) - 'a';

            if (curr.children[idx] == null) {
                return false;
            }

            curr = curr.children[idx];

        }

        return true;
    }
}