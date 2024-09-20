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
class Solution {

    TreeNode head = null;
    TreeNode temp = null;

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        traverse(root);
        root.left = null;
        root.val = head.val;
        root.right = head.right;
    }

    private void traverse(TreeNode root) {
        if (root == null) {
            return;
        }

        if (head == null) {
            head = new TreeNode(root.val);
            temp = head;

        } else {
            temp.right = new TreeNode(root.val);
            temp = temp.right;
        }

        traverse(root.left);
        traverse(root.right);
    }


}