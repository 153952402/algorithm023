import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树的前序遍历
 */
public class BinaryTreePreorderTraversalSolution {

    /**
     * 递归解法
     */
    public List<Integer> preorderTraversal_recursive(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        recursive(root, list);
        return list;
    }
    private void recursive(TreeNode root, List list) {
        if(root == null) {
            return;
        }
        list.add(root.val);
        recursive(root.left, list);
        recursive(root.right, list);
    }

    //---------------------------------------------------------------------------
    /**
     * 迭代解法
     */
    public List<Integer> preorderTraversal_loop(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                res.add(root.val);
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            root = root.right;
        }
        return res;
    }




    private class TreeNode {
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
