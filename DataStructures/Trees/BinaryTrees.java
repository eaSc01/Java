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

    static class TreeInfo {
        int diameter = 0;
        int height = 0;

        TreeInfo(int diameter, int height) {
            this.diameter = diameter;
            this.height = height;
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

    public int diameterTree(Node root) {
        // diameter either exists in left subtree, right subtree or passes through root node.
        // so the maximum of diameter of left subtree, diameter of right subtree, and Self diamater is the diameter of the root node.
        if (root == null) {
            return 0;
        }
        
        int leftHeight = calHeight(root.left);
        int leftDiameter = diameterTree(root.left);
        int rightHeight = calHeight(root.right);
        int rightDiameter = diameterTree(root.right);
        
        // formula to find self diameter
        int selfDiamter = leftHeight + rightHeight + 1;

        return Math.max(selfDiamter, Math.max(leftDiameter, rightDiameter));
    }

    public TreeInfo diameter(Node root) {
        if (root == null) {
            return new TreeInfo(0, 0);
        }

        TreeInfo leftTree = diameter(root.left);
        TreeInfo rightTree = diameter(root.right);

        int diameter = Math.max(Math.max(leftTree.diameter, rightTree.diameter), leftTree.height + rightTree.height + 1);
        int height = Math.max(leftTree.height, rightTree.height) + 1;

        return new TreeInfo(diameter, height);
    }

    public boolean identical(Node node1, Node node2) {
        if (node1 == null && node2 == null) {
            // no nodes are present, i.e, identical
            return true;

        } else if (node1 == null || node2 == null || node1.data != node2.data) {
            // the condition which makes it un identical
            return false;
        }

        // checking identity for remaining child nodes
        if (!identical(node1.left, node2.left)) {
            return false;
        }
        if (!identical(node1.right, node2.right)) {
            return false;
        }

        // if none of the above executed, then they are identical.
        return true;
    }

    public boolean subTree(Node root, Node subRoot) {
        if (root == null) {
            return false;
        }

        if (root.data == subRoot.data) {
            if (identical(root, subRoot)) {
                return true;
            }
        }

        return subTree(root.left, subRoot) || subTree(root.right, subRoot);
    }

    public static void main(String args[]) {
        BinaryTrees tree = new BinaryTrees();
        // int nodeList[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        // Node root = tree.BuildTree(nodeList);
        // System.out.println(root.data);
        // tree.preOrder(root);
        // System.out.println();
        // tree.inOrder(root);
        // System.out.println();
        // tree.postOrder(root);

        // tree.levelOrder(root);
        // System.out.println("\nHeight: " + tree.calHeight(root) + "\nNodes: " + tree.calNodes(root) + "\nSum of Nodes: " + tree.calSumOfNodes(root) + "\nDiameter: " + tree.diameter(root).diameter);

        /* Tree 1
                 0
               /   \
              1     2
             / \   / \
            3  4  5   6

         */
        Node tree1 = new Node(0);
        tree1.left = new Node(1);
        tree1.right = new Node(2);
        tree1.left.left = new Node(3);
        tree1.left.right = new Node(4);
        tree1.right.left = new Node(5);
        tree1.right.right = new Node(6);


        /* Tree 2
         
              1
             / \
            3   4
        
         */

        Node tree2 = new Node(1);
        tree2.left = new Node(3);
        tree2.right = new Node(4);


        System.out.println(tree.subTree(tree1, tree2));
    }
}