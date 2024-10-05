import java.util.*;

class LevelOrderTraversal {
    public List<List<Integer>> traverse(TreeNode root) {
        List<List<Integer>> levels = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> level = new ArrayList<>();

        queue.add(root);
        queue.add(null);

        while (!queue.isEmpty()) {
            TreeNode curr = queue.remove();

            if (curr == null) {
                levels.add(level);
                level = new ArrayList<>();
                if (queue.isEmpty()) {
                    break;
                }
                queue.add(null);

            } else {
                if (curr.left != null) queue.add(curr.left);
                if (curr.right != null) queue.add(curr.right);
                level.add(curr.val);
            }

        }

        return levels;
    }
}
