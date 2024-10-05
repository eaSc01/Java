import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int x) {
        val = x;
        left = right = null;
    }
}

class Item {
    TreeNode node;
    int offset;

    public Item(TreeNode node, int offset) {
        this.node = node;
        this.offset = offset;
    }
}

public class TopView {
    public static List<Integer> topView(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        Map<Integer, Integer> map = new HashMap<>();
        Queue<Item> q = new LinkedList<>();
        int leftMost = 0;
        int rightMost = 0;

        q.add(new Item(root, 0));

        while (!q.isEmpty()) {
            Item curr = q.remove();
            map.putIfAbsent(curr.offset, curr.node.val);

            if (curr.node.left != null) {
                q.add(new Item(curr.node.left, curr.offset - 1));
                leftMost = Math.min(leftMost, curr.offset - 1);
            }

            if (curr.node.right != null) {
                q.add(new Item(curr.node.right, curr.offset + 1));
                rightMost = Math.max(rightMost, curr.offset + 1);
            }
        }

        List<Integer> topView = new ArrayList<>();
        for (int i = leftMost; i <= rightMost; i++) {
            topView.add(map.get(i));
        }
        return topView;
    }

    public static List<Integer> bottomView(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
    
        Map<Integer, Integer> map = new HashMap<>();
        Queue<Item> q = new LinkedList<>();
        int leftMost = 0;
        int rightMost = 0;
    
        q.add(new Item(root, 0));
    
        while (!q.isEmpty()) {
            Item curr = q.remove();
            map.put(curr.offset, curr.node.val); // Store the bottom-most node
    
            if (curr.node.left != null) {
                q.add(new Item(curr.node.left, curr.offset - 1));
                leftMost = Math.min(leftMost, curr.offset - 1);
            }
    
            if (curr.node.right != null) {
                q.add(new Item(curr.node.right, curr.offset + 1));
                rightMost = Math.max(rightMost, curr.offset + 1); // Update correctly
            }
        }
    
        List<Integer> bottomView = new ArrayList<>();
        for (int i = leftMost; i <= rightMost; i++) {
            bottomView.add(map.get(i)); // Collect values in the bottom view
        }
        return bottomView;
    }
    

    public static void main(String[] args) {
        // Example tree
        TreeNode root = new TreeNode(1); // Level 1
        root.left = new TreeNode(2); // Level 2
        root.right = new TreeNode(3); // Level 2

        root.left.left = new TreeNode(4); // Level 3
        root.left.right = new TreeNode(5); // Level 3
        root.right.left = new TreeNode(6); // Level 3
        root.right.right = new TreeNode(7); // Level 3

        root.left.left.left = new TreeNode(8); // Level 4
        root.left.left.right = new TreeNode(9); // Level 4
        root.left.right.left = new TreeNode(10); // Level 4
        root.left.right.right = new TreeNode(11); // Level 4
        root.right.left.left = new TreeNode(12); // Level 4
        root.right.left.right = new TreeNode(13); // Level 4
        root.right.right.left = new TreeNode(14); // Level 4
        root.right.right.right = new TreeNode(15); // Level 4

        List<Integer> result = bottomView(root);
        for (int a : result) {
            System.out.println(a); // Output the bottom view
        }

    }
}
