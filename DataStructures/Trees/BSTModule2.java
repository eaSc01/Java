import java.util.*;

public class BSTModule2 {
    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public void getInOrder(TreeNode root, ArrayList<Integer> inOrder) {
        if (root == null) {
            return;
        }
        getInOrder(root.left, inOrder);
        inOrder.add(root.data);
        getInOrder(root.right, inOrder);
    }

    public TreeNode createBST(ArrayList<Integer> inOrder, int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(inOrder.get(mid));
        root.left = createBST(inOrder, start, mid - 1);
        root.right = createBST(inOrder, mid + 1, end);
        return root;
    }

    public TreeNode BST2BalancedTree(TreeNode root) {
        // find irorder sequence
        ArrayList<Integer> inOrder = new ArrayList<>();
        getInOrder(root, inOrder);

        // build balanced BST
        return createBST(inOrder, 0, inOrder.size() - 1);
    }

    public void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    static class Info {
        boolean isBST;
        int size;
        int min;
        int max;

        Info(boolean isBST, int size, int min, int max) {
            this.isBST = isBST;
            this.size = size;
            this.min = min;
            this.max = max;
        }
    }

    public static int maxBST = 0;

    public Info largestBSTSize(TreeNode root) {
        if (root == null) {
            return new Info(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }

        // calculate info for left and right subtrees
        Info leftInfo = largestBSTSize(root.left);
        Info rightInfo = largestBSTSize(root.right);

        // calculate info for current subtree
        int size = leftInfo.size + rightInfo.size + 1;
        int min = Math.min(root.data, Math.min(leftInfo.min, rightInfo.min));
        int max = Math.max(root.data, Math.max(leftInfo.max, rightInfo.max));

        // calculate whether current subtree is BST or not

        // current subtree is not a BST
        if (root.data <= leftInfo.max || root.data >= rightInfo.min) {
            return new Info(false, size, min, max);
        }

        // current subtree is a tree as well as its left and right subtrees, (condition
        // for current tree is been already checked in above if statement)
        if (leftInfo.isBST && rightInfo.isBST) {
            maxBST = Math.max(maxBST, size);
            return new Info(true, size, min, max);
        }

        return new Info(false, size, min, max);
    }

    public TreeNode mergeBST(TreeNode root1, TreeNode root2) {
        ArrayList<Integer> inOrderSequence = new ArrayList<>();
        // ArrayList<Integer> tree2 = new ArrayList<>();

        // calculate inorder sequence for both bst
        getInOrder(root1, inOrderSequence);
        getInOrder(root2, inOrderSequence);

        // sorting to get the inorder sequence of tree we are going to build
        Collections.sort(inOrderSequence);

        // build tree using sorted sequence of both given bst
        return createBST(inOrderSequence, 0, inOrderSequence.size() - 1);
    }

    public static void main(String[] args) {

        BSTModule2 tree = new BSTModule2();

        // Visual Tree
        // 10
        // / \
        // 9 11
        // / \
        // 8 12
        // / \
        // 7 13

        // TreeNode root = new TreeNode(10);
        // root.left = new TreeNode(9);
        // root.left.left = new TreeNode(8);
        // root.left.left.left = new TreeNode(7);
        // root.right = new TreeNode(11);
        // root.right.right = new TreeNode(12);
        // root.right.right.right = new TreeNode(13);

        // // expected tree

        // 10
        // / \
        // 8 12
        // / \ / \
        // 7 9 11 13

        // root = tree.BST2BalancedTree(root);
        // tree.preOrder(root);

        // TreeNode root = new TreeNode(50);
        // root.left = new TreeNode(30);
        // root.left.left = new TreeNode(5);
        // root.left.right = new TreeNode(20);

        // root.right = new TreeNode(60);
        // root.right.left = new TreeNode(45);
        // root.right.right = new TreeNode(70);
        // root.right.right.left = new TreeNode(65);
        // root.right.right.right = new TreeNode(80);

        // tree.largestBSTSize(root);
        // System.out.println("Largest BST Size: " + maxBST);

        TreeNode root1 = new TreeNode(2);
        root1.left = new TreeNode(1);
        root1.right = new TreeNode(4);

        TreeNode root2 = new TreeNode(9);
        root2.left = new TreeNode(3);
        root2.right = new TreeNode(12);

        tree.preOrder(tree.mergeBST(root1, root2));

    }
}