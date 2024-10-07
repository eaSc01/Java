import java.util.*;


class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i<inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return buildTree(map, inorder, 0, inorder.length - 1, preorder, 0, preorder.length - 1);
    }

    public TreeNode buildTree(
        Map<Integer, Integer> map, 
        
        int[] inorder,
        int inStart,
        int inEnd,

        int[] preorder,
        int preStart,
        int preEnd
    ) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }

        TreeNode newRoot = new TreeNode(preorder[preStart]);
        int inRoot = map.get(newRoot.val);
        int numsOnLeft = inRoot - inStart;

        newRoot.left = buildTree(map, inorder, inStart, inRoot - 1, preorder, preStart + 1, preStart + numsOnLeft);
        newRoot.right = buildTree(map, inorder, inRoot + 1, inEnd, preorder, preStart + numsOnLeft + 1, preEnd);

        return newRoot;
    }
}