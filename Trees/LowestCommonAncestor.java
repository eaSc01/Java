import java.util.*;;

class SolutionOptimal {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == p || root == q || root == null) {
            return root;  // found a node (or if root == null then return also)
        }

        TreeNode l = lowestCommonAncestor(root.left, p, q);
        TreeNode r = lowestCommonAncestor(root.right, p, q);

        if (l != null && r != null) {
            return root; // is lca
        }

        return l != null ? l : r;  // either left subtree has node or right
    }
}


class SolutionBrute {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> pPath = new ArrayList<>();
        List<TreeNode> qPath = new ArrayList<>();

        pathToNode(root, p, new ArrayList<>(), pPath);
        pathToNode(root, q, new ArrayList<>(), qPath);

        TreeNode lca = root;
        for (int i = 0; i<Math.min(pPath.size(), qPath.size()); i++) {
            if (pPath.get(i) == qPath.get(i)) {
                lca = pPath.get(i);
            } else {
                break;
            }
        }

        return lca;
    }

    public void pathToNode(TreeNode root, TreeNode target, List<TreeNode> curr, List<TreeNode> path) {
        if (root == null) {
            return;
        }

        curr.add(root);
        if (root == target) {
            path.addAll(curr);
            return;
        }

        pathToNode(root.left, target, curr, path);
        pathToNode(root.right, target, curr, path);
        curr.remove(curr.size() - 1);
    }
}