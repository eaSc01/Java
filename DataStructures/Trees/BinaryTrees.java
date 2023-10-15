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
        if (currentIdx >= nodes.length || nodes[currentIdx] == -1) {
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
        // diameter either exists in left subtree, right subtree or passes through root
        // node.
        // so the maximum of diameter of left subtree, diameter of right subtree, and
        // Self diamater is the diameter of the root node.
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
        // calculates max distance between 2 nodes in a tree

        if (root == null) {
            return new TreeInfo(0, 0);
        }

        TreeInfo leftTree = diameter(root.left);
        TreeInfo rightTree = diameter(root.right);

        int diameter = Math.max(Math.max(leftTree.diameter, rightTree.diameter),
                leftTree.height + rightTree.height + 1);
        int height = Math.max(leftTree.height, rightTree.height) + 1;

        return new TreeInfo(diameter, height);
    }

    public boolean identical(Node node1, Node node2) {
        // checks if 2 trees are identical

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
        // checks if a subtree is from a tree or not
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

    class Information {
        Node node;
        int horDistance;

        Information(Node node, int hd) {
            this.node = node;
            this.horDistance = hd;
        }
    }

    public void topView(Node root) {
        // Prints top view of a tree, using Queue and HashMap

        Queue<Information> q = new LinkedList<>();
        HashMap<Integer, Node> map = new HashMap<>();

        int min = 0, max = 0;
        q.add(new Information(root, 0));
        q.add(null);

        // traversal using level Order
        while (!q.isEmpty()) {
            Information curr = q.remove();

            if (curr == null) {
                if (q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                }

            } else {
                // adding node and hd in maps if they doesnt exist in it already
                if (!map.containsKey(curr.horDistance)) {
                    map.put(curr.horDistance, curr.node);
                }

                // adding child nodes info in queue
                if (curr.node.left != null) {
                    q.add(new Information(curr.node.left, curr.horDistance - 1));
                    min = Math.min(min, curr.horDistance - 1);
                }
                if (curr.node.right != null) {
                    q.add(new Information(curr.node.right, curr.horDistance + 1));
                    max = Math.max(max, curr.horDistance + 1);
                }
            }
        }

        // Printing HashMap containing top View nodes
        for (int i = min; i <= max; i++) {
            System.out.print(map.get(i).data + "\t");
        }
    }

    public void kLevel(Node root, int level, int K) {
        if (root == null) {
            return;
        }

        if (level == K) {
            System.out.print(root.data + "\t");
            return;
        }

        kLevel(root.left, level + 1, K);
        kLevel(root.right, level + 1, K);
    }

    public boolean getPath(Node root, int n, ArrayList<Node> path) {

        // base case for tree reaching leaves
        if (root == null) {
            return false;
        }

        // main
        path.add(root);
        if (root.data == n) {
            return true;
        }

        // call for children nodes
        boolean left = getPath(root.left, n, path);
        boolean right = getPath(root.right, n, path);

        // operation on children nodes
        if (left || right) {
            return true;
        } else {
            path.remove(path.size() - 1);
            return false;
        }
    }

    public Node lowestCommonAncestor(Node root, int n1, int n2) {

        ArrayList<Node> path1 = new ArrayList<>();
        ArrayList<Node> path2 = new ArrayList<>();

        getPath(root, n1, path1);
        getPath(root, n2, path2);

        int i;

        for (i = 0; i < path1.size() && i < path2.size(); i++) {
            if (path1.get(i).data != path2.get(i).data) {
                break;
            }
        }

        Node lca = path1.get(i - 1);
        return lca;
    }

    public Node lca(Node root, int n1, int n2) {
        // base case (null) + checks if the current subroot is either n1 or n2
        if (root == null || root.data == n1 || root.data == n2) {
            return root;
        }

        // current node has been checked, and found its not n1 and n2, then
        // call same function for left and right nodes
        Node left = lca(root.left, n1, n2);
        Node right = lca(root.right, n1, n2);

        // when a node is found on left node but not on right node, so just return the
        // leftnode
        if (right == null) {
            return left;
        }
        // when a node is found on right node but not on left node, so just return the
        // rightnode
        if (left == null) {
            return right;
        }

        // when both left and right nodes are not null, hence, the current node, i.e,
        // subroot is the parent ancestor for both
        return root;
    }

    public int dist(Node root, int n) {
        // base case when root is not found
        if (root == null) {
            return -1;
        }

        // when root is found at current level (overlapps), so distance between current
        // node and current node is obviously 0
        if (root.data == n) {
            return 0;
        }

        // calculating for child nodes
        int left = dist(root.left, n);
        int right = dist(root.right, n);

        // returning only the available nodes
        if (left == -1 && right == -1) {
            return -1;
        } else if (right == -1) {
            return left + 1;
        } else {
            return right + 1;
        }
    }

    public int minDist(Node root, int n1, int n2) {

        // getting the lowest ancestor node for both given node's data, to find minimum
        // distance
        Node lca = lca(root, n1, n2);

        // calculating distances between n1 and lca, and n2 and lca, their sum adds upto
        // min Distance.
        int distance1 = dist(lca, n1);
        int distance2 = dist(lca, n2);

        return distance1 + distance2;
    }

    public int kAncestor(Node root, int n, int K) {
        if (root == null) {
            return -1;
        }

        if (root.data == n) {
            return 0;
        }

        int left = kAncestor(root.left, n, K);
        int right = kAncestor(root.right, n, K);

        if (left == -1 && right == -1) {
            return -1;
        }

        int max = Math.max(left, right) + 1;

        if (max == K) {
            System.out.println(root.data);
        } 

        return max;
    }

    public int transform(Node root) {
        if (root == null) {
            return 0;
        }

        int leftChild = transform(root.left);
        int rightChild = transform(root.right);

        int data = root.data;
        int newLeft = (root.left == null) ? 0 : root.left.data;
        int newRight = (root.right == null) ? 0 : root.right.data;

        root.data = leftChild + rightChild + newLeft + newRight;
        return data;
    }
    public static void main(String args[]) {
        BinaryTrees tree = new BinaryTrees();
        // int nodeList[] = { 3, 5, 1, 6, 2, 0, 8, -1, -1, 7, 4 };
        // Node root = tree.BuildTree(nodeList);
        /*
         * Tree 1
         * 0
         * / \
         * 1 2
         * / \ / \
         * 3 4 5 6
         * 
         */
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        tree.levelOrder(root);
        System.out.println();

        /*
        * Tree 2
         * 
         * 1
         * / \
         * 3 4
         * 
         */

        // Node tree2 = new Node(1);
        // tree2.left = new Node(3);
        // tree2.right = new Node(4);
        
        // System.out.println(root.data);
        // tree.preOrder(root);
        // System.out.println();
        // tree.inOrder(root);
        // System.out.println();
        // tree.postOrder(root);
        
        // tree.levelOrder(root);
        // System.out.println("\nHeight: " + tree.calHeight(root) + "\nNodes: " +
        // tree.calNodes(root) + "\nSum of Nodes: " + tree.calSumOfNodes(root) +
        // "\nDiameter: " + tree.diameter(root).diameter);

        // System.out.println(tree.subTree(tree1, tree2));
        // tree.topView(tree1);
        // tree.kLevel(tree1, 1, 2);
        // System.out.println(tree.lowestCommonAncestor(root, 5, 1).data);
        // System.out.println(tree.minDist(tree1, 3, 6));
        // tree.kAncestor(root, 4, 1);
        // tree.transform(root);
    }
}