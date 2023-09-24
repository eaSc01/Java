import java.util.*;
import java.util.LinkedList;

public class BinaryTrees {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static int currentIdx = -1;

    public Node BuildTree(int nodes[]) {
        // builds a tree using pre order nodes in an array
        // dry run pending

        currentIdx++;
        if (nodes[currentIdx] == -1) {
            return null;
        }

        Node newNode = new Node(nodes[currentIdx]);
        newNode.left = BuildTree(nodes);
        newNode.right = BuildTree(nodes);

        return newNode;
    }

    public void preOrder(Node root) { // O(n) TC
        // root, left subtree, right subtree
        if (root == null) {
            // System.out.print("-1\t");
            return;
        }
        System.out.print(root.data + "\t");
        preOrder(root.left);
        preOrder(root.right);
    }

    public void inOrder(Node root) { // O(n) TC
        // left subtree, root of subtree, right subtree
        if (root == null) {
            // System.out.print("-1\t");
            return;
        }
        inOrder(root.left);
        System.out.print(root.data + "\t");
        inOrder(root.right);
    }

    public void postOrder(Node root) { // O(n) TC
        // left subtree, right subtree, root of subtree
        if (root == null) {
            // System.out.print("-1\t");
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + "\t");
    }

    public void levelOrder(Node root) {
        if (root == null) {
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);

        while (!queue.isEmpty()) {
            Node currNode = queue.remove();

            if (currNode == null) {
                System.out.println();
                if (queue.isEmpty()) {
                    break;
                } else {
                    queue.add(null);
                }
            } else {
                System.out.print(currNode.data + " ");
                if (currNode.left != null) {
                    queue.add(currNode.left);
                }
                if (currNode.right != null) {
                    queue.add(currNode.right);
                }
            }
        }
    }

    public int calHeight(Node root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = calHeight(root.left);
        int leftRight = calHeight(root.right);
        return Math.max(leftHeight, leftRight) + 1;  
    }

    public int calNodes(Node root) {
        if (root == null) {
            return 0;
        }

        int leftCount = calNodes(root.left);
        int rightCount = calNodes(root.right);
        return leftCount + rightCount + 1;
    }

    public int calSumOfNodes(Node root) {
        if (root == null) {
            return 0;
        }

        int leftSum = calSumOfNodes(root.left);
        int rightSum = calSumOfNodes(root.right);
        return (leftSum + rightSum + root.data);
    }

    public static void main(String args[]) {
        int nodeList[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        BinaryTrees tree = new BinaryTrees();
        Node root = tree.BuildTree(nodeList);
        // System.out.println(root.data);
        // tree.preOrder(root);
        // System.out.println();
        // tree.inOrder(root);
        // System.out.println();
        // tree.postOrder(root);

        tree.levelOrder(root);
        System.out.println("\nHeight: " + tree.calHeight(root) + "\nNodes: " + tree.calNodes(root) + "\nSum of Nodes: " + tree.calSumOfNodes(root));
    }
}