import java.util.*;

public class PathToNode {
    
    public static List<Integer> findPath(TreeNode root, int target) {
        List<Integer> path = new ArrayList<>();
        dfs(root, new ArrayList<>(), path, target);
        return path;
    }

    public static void dfs(TreeNode root, List<Integer> curr, List<Integer> path, int target) {
        if (root == null) {
            return;
        }

        curr.add(root.val);
        if (root.val == target) {
            path.addAll(new ArrayList<>(curr));
            return;
        }

        dfs(root.left, curr, path, target);
        dfs(root.right, curr, path, target);
        curr.remove(curr.size() - 1);
    }

    public static void main(String[] args) {
        // Example tree
        TreeNode root = new TreeNode(1);

        // Level 2
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        // Level 3
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        // Level 4
        root.left.left.left = new TreeNode(8);
        root.left.left.right = new TreeNode(9);
        root.left.right.left = new TreeNode(10);
        root.left.right.right = new TreeNode(11);
        root.right.left.left = new TreeNode(12);
        root.right.left.right = new TreeNode(13);
        root.right.right.left = new TreeNode(14);
        root.right.right.right = new TreeNode(15);

        // Level 5
        root.left.left.left.left = new TreeNode(16);
        root.left.left.left.right = new TreeNode(17);
        root.left.left.right.left = new TreeNode(18);
        root.left.left.right.right = new TreeNode(19);
        root.left.right.left.left = new TreeNode(20);
        root.left.right.left.right = new TreeNode(21);
        root.left.right.right.left = new TreeNode(22);
        root.left.right.right.right = new TreeNode(23);
        
        root.right.left.left.left = new TreeNode(24);
        root.right.left.left.right = new TreeNode(25);
        root.right.left.right.left = new TreeNode(26);
        root.right.left.right.right = new TreeNode(27);
        root.right.right.left.left = new TreeNode(28);
        root.right.right.left.right = new TreeNode(29);
        root.right.right.right.left = new TreeNode(30);
        root.right.right.right.right = new TreeNode(31);
        
        // Level 6
        root.left.left.left.left.left = new TreeNode(32);
        root.left.left.left.left.right = new TreeNode(33);
        root.left.left.left.right.left = new TreeNode(34);
        root.left.left.left.right.right = new TreeNode(35);
        root.left.right.left.left.left = new TreeNode(36);
        root.left.right.left.left.right = new TreeNode(37);
        root.left.right.left.right.left = new TreeNode(38);
        root.left.right.left.right.right = new TreeNode(39);
        root.left.right.right.left.left = new TreeNode(40);
        root.left.right.right.left.right = new TreeNode(41);
        root.left.right.right.right.left = new TreeNode(42);
        root.left.right.right.right.right = new TreeNode(43);
        
        root.right.left.left.left.left = new TreeNode(44);
        root.right.left.left.left.right = new TreeNode(45);
        root.right.left.left.right.left = new TreeNode(46);
        root.right.left.left.right.right = new TreeNode(47);
        root.right.left.right.left.left = new TreeNode(48);
        root.right.left.right.left.right = new TreeNode(49);
        root.right.left.right.right.left = new TreeNode(50);
        root.right.left.right.right.right = new TreeNode(51);
        
        root.right.right.left.left.left = new TreeNode(52);
        root.right.right.left.left.right = new TreeNode(53);
        root.right.right.left.right.left = new TreeNode(54);
        root.right.right.left.right.right = new TreeNode(55);
        root.right.right.right.left.left = new TreeNode(56);
        root.right.right.right.left.right = new TreeNode(57);
        root.right.right.right.right.left = new TreeNode(58);
        root.right.right.right.right.right = new TreeNode(59);
        
        // Level 7
        root.left.left.left.left.left.left = new TreeNode(60);
        root.left.left.left.left.left.right = new TreeNode(61);
        root.left.left.left.left.right.left = new TreeNode(62);
        root.left.left.left.left.right.right = new TreeNode(63);
        
        root.left.left.left.right.left.left = new TreeNode(64);
        root.left.left.left.right.left.right = new TreeNode(65);
        root.left.left.left.right.right.left = new TreeNode(66);
        root.left.left.left.right.right.right = new TreeNode(67);
        
        root.left.right.left.left.left.left = new TreeNode(68);
        root.left.right.left.left.left.right = new TreeNode(69);
        root.left.right.left.left.right.left = new TreeNode(70);
        root.left.right.left.left.right.right = new TreeNode(71);
        
        root.left.right.left.right.left.left = new TreeNode(72);
        root.left.right.left.right.left.right = new TreeNode(73);
        root.left.right.left.right.right.left = new TreeNode(74);
        root.left.right.left.right.right.right = new TreeNode(75);
        
        root.left.right.right.left.left.left = new TreeNode(76);
        root.left.right.right.left.left.right = new TreeNode(77);
        root.left.right.right.left.right.left = new TreeNode(78);
        root.left.right.right.left.right.right = new TreeNode(79);
        
        root.left.right.right.right.left.left = new TreeNode(80);
        root.left.right.right.right.left.right = new TreeNode(81);
        root.left.right.right.right.right.left = new TreeNode(82);
        root.left.right.right.right.right.right = new TreeNode(83);
        
        root.right.left.left.left.left.left = new TreeNode(84);
        root.right.left.left.left.left.right = new TreeNode(85);
        root.right.left.left.left.right.left = new TreeNode(86);
        root.right.left.left.left.right.right = new TreeNode(87);
        
        root.right.left.left.right.left.left = new TreeNode(88);
        root.right.left.left.right.left.right = new TreeNode(89);
        root.right.left.left.right.right.left = new TreeNode(90);
        root.right.left.left.right.right.right = new TreeNode(91);
        
        root.right.left.right.left.left.left = new TreeNode(92);
        root.right.left.right.left.left.right = new TreeNode(93);
        root.right.left.right.left.right.left = new TreeNode(94);
        root.right.left.right.left.right.right = new TreeNode(95);
        
        root.right.left.right.right.left.left = new TreeNode(96);
        root.right.left.right.right.left.right = new TreeNode(97);
        root.right.left.right.right.right.left = new TreeNode(98);
        root.right.left.right.right.right.right = new TreeNode(99);
        
        root.right.right.left.left.left = new TreeNode(100);
        root.right.right.left.left.right = new TreeNode(101);
        root.right.right.left.right.left = new TreeNode(102);
        root.right.right.left.right.right = new TreeNode(103);
        
        root.right.right.right.left.left = new TreeNode(104);
        root.right.right.right.left.right = new TreeNode(105);
        root.right.right.right.right.left = new TreeNode(106);
        root.right.right.right.right.right = new TreeNode(107);

        List<Integer> result = findPath(root, 42);
        for (int a : result) {
            System.out.println(a); // Output the bottom view
        }

    }
}