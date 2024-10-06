import java.util.*;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Item {
    TreeNode node;
    int x;

    public Item(TreeNode node, int x) {
        this.node = node;
        this.x = x;
    }
}

class Solution2 {
    public int widthOfBinaryTree(TreeNode root) {
        Stack<List<Integer>> pairs = new Stack<>();
        Queue<Item> q = new LinkedList<>();
        boolean isFirst = true;

        q.add(new Item(root, 0));
        q.add(null);

        while (!q.isEmpty()) {
            Item curr = q.remove();

            if (curr == null) {
                isFirst = true;
                if (q.isEmpty()) {
                    break;
                }
                q.add(null);

            } else {
                // if first
                if (isFirst) {
                    List<Integer> newPair = new ArrayList<>();
                    newPair.add(curr.x);
                    pairs.push(new ArrayList<>(newPair));
                    isFirst = false;
                }

                // if last
                if (!q.isEmpty() && q.peek() == null) {
                    pairs.peek().add(curr.x);
                }

                // add children
                if (curr.node.left != null) {
                    q.add(new Item(curr.node.left, 2 * curr.x + 1));
                }

                if (curr.node.right != null) {
                    q.add(new Item(curr.node.right, 2 * curr.x + 2));
                }
            }
        }

        int maxWidth = 0;
        while (!pairs.empty()) {
            List<Integer> pair = pairs.pop();
            int width = pair.get(1) - pair.get(0) + 1;
            maxWidth = Math.max(width, maxWidth);
        }

        return maxWidth;
    }

}

class Pair<K,V> {
    private K key;
    private V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;

    }

    public V getValue() {
        return value;
    }
}

class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int maxWidth = 0;
        Queue<Pair<TreeNode, Integer>> q = new LinkedList<>();
        q.add(new Pair<>(root, 0));

        while (!q.isEmpty()) {
            int levelSize = q.size();
            int levelStart = q.peek().getValue();
            int index = 0;

            for (int i = 0; i<levelSize; i++) {
                Pair<TreeNode, Integer> pair = q.remove();
                index = pair.getValue();
                TreeNode node = pair.getKey();

                if (node.left != null) {
                    q.add(new Pair<>(node.left, 2 * index + 1));
                }

                if (node.right != null) {
                    q.add(new Pair<>(node.right, 2 * index + 2));
                }
            }

            maxWidth = Math.max(maxWidth, index - levelStart + 1);
        }

        return maxWidth;
    }
}