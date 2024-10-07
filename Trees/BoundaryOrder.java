import java.util.*;

public class BoundaryOrder {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1); // Level 1
        // root.left = new TreeNode(2); // Level 2
        // root.right = new TreeNode(3); // Level 2

        // root.left.left = new TreeNode(4); // Level 3
        // root.left.right = new TreeNode(5); // Level 3
        // root.right.left = new TreeNode(6); // Level 3
        // root.right.right = new TreeNode(7); // Level 3

        // root.left.left.left = new TreeNode(8); // Level 4
        // root.left.left.right = new TreeNode(9); // Level 4
        // root.left.right.left = new TreeNode(10); // Level 4
        // root.left.right.right = new TreeNode(11); // Level 4
        // root.right.left.left = new TreeNode(12); // Level 4
        // root.right.left.right = new TreeNode(13); // Level 4
        // root.right.right.left = new TreeNode(14); // Level 4
        // root.right.right.right = new TreeNode(15); // Level 4

        
        List<Integer> result = boundary(root);
        for (int a : result) {
            System.out.println(a); // Output the bottom view
        }
        
    }

    public static List<Integer> boundary(TreeNode root) {
        List<Integer> nodes = new ArrayList<>();

        if (root == null) {
            return nodes;
        }

        if (!isLeaf(root)) {
            nodes.add(root.val);
        }

        addLeftBoundary(root, nodes);
        addLeaves(root, nodes);
        addRightBoundary(root, nodes);

        return nodes;
    }

    private static boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }

    private static void addLeftBoundary(TreeNode root, List<Integer> nodes) {
        TreeNode curr = root.left;

        while (curr != null) {
            if (!isLeaf(curr)) {
                nodes.add(curr.val);
            }

            if (curr.left != null) {
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }
    }

    private static void addRightBoundary(TreeNode root, List<Integer> nodes) {
        List<Integer> temp = new ArrayList<>();
        TreeNode curr = root.right;

        while (curr != null) {
            if (!isLeaf(curr)) {
                temp.add(curr.val);
            }

            if (curr.right != null) {
                curr = curr.right;
            } else {
                curr = curr.left;
            }
        }

        for (int i = temp.size() - 1; i>= 0; i--) {
            nodes.add(temp.get(i));
        }
    }

    private static void addLeaves(TreeNode root, List<Integer> nodes) {
        if (root == null) {
            return;
        }

        addLeaves(root.left, nodes);
        if (isLeaf(root)) {
            nodes.add(root.val);
        }
        addLeaves(root.right, nodes);
    } 


}