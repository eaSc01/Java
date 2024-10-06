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
class Tuple {
    TreeNode node;
    int vertical;
    int level;

    public Tuple(TreeNode node, int vertical, int level) {
        this.node = node;
        this.vertical = vertical;
        this.level = level;
    }
}

class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Queue<Tuple> q = new LinkedList<>();
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        q.add(new Tuple(root, 0, 0));

        while (!q.isEmpty()) {
            Tuple tuple = q.remove();
            TreeNode node = tuple.node;
            int vertical = tuple.vertical;
            int level = tuple.level;

            if (!map.containsKey(vertical)) {
                map.put(vertical, new TreeMap<>());
            }

            if (!map.get(vertical).containsKey(level)) {
                map.get(vertical).put(level, new PriorityQueue<>());
            }

            map.get(vertical).get(level).offer(node.val);

            if (node.left != null) {
                q.offer(new Tuple(node.left, vertical - 1, level + 1));
            }

            if (node.right != null) {
                q.offer(new Tuple(node.right, vertical + 1, level + 1));
            }
        }
        
        List<List<Integer>> tree = new ArrayList<>();
        for (TreeMap<Integer, PriorityQueue<Integer>> levels: map.values()) {
            tree.add(new ArrayList<>());
            
            for (PriorityQueue<Integer> values: levels.values()) {
                while (!values.isEmpty()) {
                    tree.get(tree.size() - 1).add(values.poll());
                }
            }
        }

        return tree;
    }
}