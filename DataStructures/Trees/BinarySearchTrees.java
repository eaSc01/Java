import java.util.*;

public class BinarySearchTrees {
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

    public TreeNode buildTree(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }

        if (root.data > val) {
            root.left = buildTree(root.left, val);
        } else {
            root.right = buildTree(root.right, val);
        }

        return root;
    }

    public void inOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }

        inOrderTraversal(root.left);
        System.out.print(root.data + " ");
        inOrderTraversal(root.right);
    }

    public boolean searchBST(TreeNode root, int key) {
        if (root == null) {
            return false;
        }

        if (root.data == key) {
            return true;
        }
        if (root.data > key) {
            return searchBST(root.left, key);
        }
        if (root.data < key) {
            return searchBST(root.right, key);
        }
        return false;
    }

    // Deletion,
    // Case 1) no child, return null to parent
    // Case 2) single child, return grandchild to root
    // Case 3) 2 children,
    // i) find inorder successor, i.e, the leftmost (minimum) node in its right sub
    // tree,
    // ii) replace node to be deleted, with the leftmost node found
    // iii) delete the node for inorder successor.

    public TreeNode delete(TreeNode root, int val) {
        // search node
        if (root.data > val) {
            root.left = delete(root.left, val);

        } else if (root.data < val) {
            root.right = delete(root.right, val);

        } else {
            // no child
            if (root.left == null && root.right == null) {
                return null;
            }

            // single child
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            // 2 children
            TreeNode inOrderSuccessor = findInOrderSuccessor(root.right);
            root.data = inOrderSuccessor.data;
            root.right = delete(root, inOrderSuccessor.data);
        }

        // for all cases where deletion isnt required, just to follow up recursive call
        // stacks
        return root;
    }

    public TreeNode findInOrderSuccessor(TreeNode root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    public void printInRange(TreeNode root, int k1, int k2) {
        if (root == null) {
            return;
        }

        // range lies in both left and right sub trees
        if (root.data >= k1 && root.data <= k2) {
            printInRange(root.left, k1, k2);
            System.out.print(root.data + " ");
            printInRange(root.right, k1, k2);
        }

        else if (root.data > k1) {
            printInRange(root.left, k1, k2);
        }

        else if (root.data < k2) {
            printInRange(root.right, k1, k2);
        }
    }

    public void printPathWise(TreeNode root, ArrayList<Integer> list) {
        if (root == null) {
            return;
        }

        list.add(root.data);
        if (root.left == null && root.right == null) {
            System.out.println(list);
        }

        printPathWise(root.left, list);
        printPathWise(root.right, list);

        list.remove(list.size() - 1);
    }

    public boolean validBST(TreeNode root, TreeNode min, TreeNode max) {
        // base case for empty tree, and also for leave nodes, to return back after reaching the leaf node
        if (root == null) {
            return true;
        }

        // check if curr data is less than the minimum val allowed
        if (min != null && root.data <= min.data) {
            return false;

            // check if curr data is greater than the maximum val allowed
        } else if (max != null && root.data >= max.data) {
            return false;
        }

        // check for remaining subtrees in same manner.

        // check for left subtree, passing curr root as the max value allowed in left
        // subtree, because the left subtree is supposed to be smaller than the root, so
        // pass curr node as max val allowed in left subtree
        if (!validBST(root.left, min, root)) {
            return false;

        // // similarly for right subtree, the values in right subtree is supposed to be
        // // greater than the root val, therefore pass curr node val as the minimum val
        // // allowed in the right subtree
        } else if (!validBST(root.right, root, max)) {
            return false;
        }

        // or
        // return validBST(root.left, min, root) && validBST(root.right, root, max);

        // if satisfies all the conditions
        return true;
    }

    public static void main(String[] args) {
        BinarySearchTrees tree = new BinarySearchTrees();
        TreeNode root = null;
        int treeNodes[] = { 5, 1, 4, 2, 3 };
        for (int i = 0; i < treeNodes.length; i++) {
            root = tree.buildTree(root, treeNodes[i]);
        }

        // tree.inOrderTraversal(root);
        // System.out.println(root.data);
        // System.out.println(tree.searchBST(root, 5));
        // System.out.println(tree.searchBST(root, 4));
        // System.out.println(tree.searchBST(root, 0));

        // root = tree.delete(root, 5);
        tree.inOrderTraversal(root);
        // System.out.println();

        // tree.printInRange(root, 2, 4);

        // tree.printPathWise(root, new ArrayList<>());
        System.out.println(tree.validBST(root, null, null));

    }
}