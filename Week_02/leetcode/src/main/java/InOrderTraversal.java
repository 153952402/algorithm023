import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树的中序遍历
 */
public class InOrderTraversal {
    /**
     * 递归解法
     */
    public List<Integer> inorderTraversal_recursive(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        recursive(root, list);
        return list;
    }
    private void recursive(TreeNode root, List<Integer> list) {
        if(root == null) {
            return;
        }
        recursive(root.left, list);
        list.add(root.val);
        recursive(root.right, list);
    }

    /**
     * 迭代解法
     */
    public List<Integer> inorderTraversal_loop(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            res.add(root.val);
            root = root.right;
        }
        return res;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
