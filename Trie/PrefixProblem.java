package Trie;

public class PrefixProblem {
    static class Node {
        Node[] children;
        boolean eow;
        int freq;

        public Node() {
            children = new Node[26];
            eow = false;
            freq = 1;
        }
    }

    public static Node root = new Node();

    public static void insert(String s) {
        Node curr = root;

        for (int i = 0; i<s.length(); i++) {
            int idx = s.charAt(i) - 'a';

            if (curr.children[idx] == null) {
                curr.children[idx] = new Node();

            } else {
                curr.children[idx].freq++;

            }
            curr = curr.children[idx];
        }

        curr.eow = true;
    }

    public static String search(String s) {
        StringBuilder sb = new StringBuilder();
        Node curr = root;

        for (int i = 0; i<s.length(); i++) {
            int idx = s.charAt(i) - 'a';

            if (curr.children[idx] != null) {
                sb.append(s.charAt(i));

                if (curr.children[idx].freq == 1) {
                    break;
                } else {
                    curr = curr.children[idx];
                }

            } else {
                return null;
            }
        }

        return sb.toString();
    }

    public static String[] prefixProblem(String[] words) {
        String[] prefix = new String[words.length];

        for (String word: words) {
            insert(word);
        }

        for (int i = 0; i<prefix.length; i++) {
            prefix[i] = search(words[i]);
        }

        return prefix;
    }

    public static void main(String[] args) {
        String[] arr = { "dog", "zebra", "duck", "dove"};
        String[] pre = prefixProblem(arr);

        for (String p: pre) {
            System.out.println(p);
        }
    }
}