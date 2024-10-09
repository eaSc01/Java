package Trie;

public class LongestWordWithAllPrefix {

    static class Node {
        Node[] children;
        boolean eow;

        public Node() {
            children = new Node[26];
            eow = false;
        }
    }

    public static Node root = new Node();

    public static void insert(String s) {
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

    static String ans = "";

    public static void longestWordWithAllPrefix(Node root, StringBuilder sb) {
        if (root == null) {
            return;
        }

        for (int i = 0; i<26; i++) {
            char currChar = (char) (i + 'a');

            if (root.children[i] != null && root.children[i].eow == true) {
                sb.append(currChar);

                if (sb.length() > ans.length()) {
                    ans = sb.toString();
                }

                longestWordWithAllPrefix(root.children[currChar - 'a'], sb);
                sb.deleteCharAt(sb.length() - 1);
            }

        }

    }

    
    public static void main(String[] args) {
        String[] words = {"a","ap", "app", "appl", "apple", "banana"};

        for (String s: words) {
            insert(s);
        }

        longestWordWithAllPrefix(root, new StringBuilder());
        System.out.println(ans);
      
    }

}
