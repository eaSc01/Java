import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    // Make the constructor public
    public TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

public class LeftViewRightView {
    public static void main(String[] args) {
        // Creating the tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);

        List<Integer> leftView = leftView(root);
        for (int a : leftView) {
            System.out.println(a);
        }
    }

    public static List<Integer> rightView(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<Integer> right = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);
        q.add(null);

        while (!q.isEmpty()) {
            TreeNode curr = q.remove();

            if (curr != null) {
                if (!q.isEmpty() && q.peek() == null) {
                    right.add(curr.val);
                }
                if (curr.left != null) q.add(curr.left);
                if (curr.right != null) q.add(curr.right);

            } else {
                if (q.isEmpty()) {
                    break;
                }
                q.add(null);
            }
        }

        return right;
    }

    public static List<Integer> leftView(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<Integer> left = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);
        q.add(null);

        while (!q.isEmpty()) {
            TreeNode curr = q.remove();

            if (curr != null) {
                if (!q.isEmpty() && q.peek() == null) {
                    left.add(curr.val);
                }
                if (curr.right != null) q.add(curr.right);
                if (curr.left != null) q.add(curr.left);

            } else {
                if (q.isEmpty()) {
                    break;
                }
                q.add(null);
            }
        }

        return left;
    }
}
