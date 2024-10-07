import java.util.*;

class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i<inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return buildTree(map, inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    public TreeNode buildTree(
        Map<Integer, Integer> map,
        int[] inorder,
        int inStart,
        int inEnd,

        int[] postorder,
        int postStart,
        int postEnd  
    ) {
        if (inStart > inEnd || postStart > postEnd) {
            return null;
        }

        TreeNode root = new TreeNode(postorder[postEnd]);
        int inRoot = map.get(root.val);
        int numsOnLeft = inRoot - inStart;

        root.left = buildTree(
            map, 
            inorder, 
            inStart, 
            inRoot - 1, 
            postorder, 
            postStart, 
            postStart + numsOnLeft - 1
        );

        root.right = buildTree(
            map, 
            inorder, 
            inRoot + 1, 
            inEnd, 
            postorder, 
            postStart + numsOnLeft,
            postEnd - 1
        );

        return root;
    }

}