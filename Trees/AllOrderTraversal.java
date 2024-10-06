import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class AllOrderTraversal {
    public static List<List<Integer>> getTreeTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>());
        ans.add(new ArrayList<>());
        ans.add(new ArrayList<>());

        traverse(root, ans);
        return ans;
    }

    public static void traverse(TreeNode root, List<List<Integer>> ans) {
        if (root == null) {
            return;
        }

        ans.get(1).add(root.val);
        traverse(root.left, ans);
        ans.get(0).add(root.val);
        traverse(root.right, ans);
        ans.get(2).add(root.val);
    }


}